// 第一步：基本介面及 text 欄位事件
// 1. index.html 頁面需載入 jquery 以及 index.js
// 2. input.task_name 在 focus 事件觸發時，div.task_add_block 加上 -on class。
// 3. input.task_name 在 blur 事件觸發時，div.task_add_block 移除 -on class。
$(function () {
  $("input.task_name").on("focus", function () {
    $(this).closest("div.task_add_block").addClass("-on");
  });

  $("input.task_name").on("blur", function () {
    $(this).closest("div.task_add_block").removeClass("-on");
  });
});

// 第二步：新增待辦事項
// 1. 按下「新增」按鈕時，將以上的待辦事項 html，新增到 ul.task_list 裡，新增到裡面的最前面。
// 2. 如果沒有輸入待辦事項，按「新增」的話，不能有任何反應。
// 3. 新增成功的話，待辦事項欄位要清空。
// 4. 輸入的待辦事項，如果文字的最左邊、最右邊有空格，需移除。(語法：JS 內建的 trim() 函式)。
// 5. 按下「Enter」鍵，也要能新增待辦事項。

function addTask() {
  // 儲存用戶 input
  let userInput = $("input.task_name").val().trim();
  // 確認是否為空值
  if (userInput === "") return;
  // 清空
  $("input.task_name").val("");
  // 【 MAIN 】開始新增任務 避免 html insertion
  let task_str = `<li>
  <div class="item_flex">
    <div class="left_block">
      <div class="btn_flex">
        <button type="button" class="btn_up">往上</button>
        <button type="button" class="btn_down">往下</button>
      </div>
    </div>
    <div class="middle_block">
      <div class="star_block">
        <span class="star" data-star="1"><i class="fas fa-star"></i></span>
        <span class="star" data-star="2"><i class="fas fa-star"></i></span>
        <span class="star" data-star="3"><i class="fas fa-star"></i></span>
        <span class="star" data-star="4"><i class="fas fa-star"></i></span>
        <span class="star" data-star="5"><i class="fas fa-star"></i></span>
      </div>
      <p class="para"></p>
      <input
                  type="text"
                  class="task_name_update -none"
                  placeholder="更新待辦事項…"
                  value=""
                />
    </div>
    <div class="right_block">
      <div class="btn_flex">
        <button type="button" class="btn_update">更新</button>
        <button type="button" class="btn_delete">移除</button>
      </div>
    </div>
  </div>
</li>`;
  let $li = $(task_str);
  $li.find("p.para").text(userInput); // 只設文字，不會當 HTML
  $li.find("input.task_name_update").val(userInput);

  $("ul.task_list").prepend($li);
}

// 1. 透過 點按鈕 新增任務
$("button.task_add").on("click", function () {
  addTask();
});

// 2. 透過 按下enter 新增任務
$("input.task_name").on("keyup", function (e) {
  if (e.key !== "Enter") return;
  addTask();
  // 因為不像是點了 btn 會像是 blur 自動有綁定 class 要另外做
  $(this).blur();
  $("div.task_add_block").removeClass("-on");
});

// 第三步：移除與清空
// 1. 按下「移除」按鈕，淡出 1 秒，然後移除該筆待辦事項。
// 2. 按下「清空」按鈕，淡出 1 秒，清除全部的待辦事項。

// 單筆移除
$(document).on("click", "button.btn_delete", function () {
  if (confirm("確認移除？") === false) return;

  $(this)
    .closest("li")
    .fadeOut(1000, function () {
      $(this).remove();
    });
});
// 全部移除
$("button.btn_empty").on("click", function () {
  if (confirm("確認清空？") === false) return;

  $("ul.task_list li").fadeOut(1000, function () {
    $(this).remove();
  });
});

// 第四步：更新待辦事項
// 1. 按下「更新」按鈕，出現一般文字框，然後可以更新。
// 2. 再按下「更新」按鈕，回到不可編輯的狀態，但待辦事項要是更新的。
// 3. 如果所更新的待辦事項，沒有輸入文字，跳出提醒視窗(alert)，顯示「請輸入待辦事項」。
// 4. 待辦事項的文字若最左邊、最右邊有空格的話，需移除。

$(document).on("click", "button.btn_update", function () {
  let staticPara = $(this).closest("li").find("p.para");
  let updateInput = $(this).closest("li").find("input.task_name_update");
  let updateInputVal = updateInput.val().trim();
  // 每點一次更新按鈕就「交換顯示」
  // 雖然兩邊都會觸發，但針對 update 輸入完後進行檢查
  if (updateInputVal === "") {
    alert("請輸入待辦事項");
    return;
  }
  staticPara.text(updateInputVal);
  staticPara.toggle();
  updateInput.toggleClass("-none"); // display: none
});

// 第五步：排序
// 1. 按下「往上」按鈕，與上面的待辦事項對調。(註：每個待辦事項是以 li 為單位。)
// 2. 按下「往下」按鈕，與下面的待辦事項對調。
// 3. 第一個的待辦事項，「往上」按鈕按了要沒反應；最後一個的待辦事項，「往下」按鈕按了要沒反應。

function changeOrder() {
  if ($(this).is("button.btn_up")) {
    if ($(this).closest("li").is(":first-child")) return;

    let prevList = $(this).closest("li").prev();
    let curList = $(this).closest("li");
    let prevListCloned = prevList.clone();
    let curListCloned = curList.clone();
    prevList.replaceWith(curListCloned);
    curList.replaceWith(prevListCloned);
  } else {
    if ($(this).closest("li").is(":last-child")) return;

    let nextList = $(this).closest("li").next();
    let curList = $(this).closest("li");
    let nextListCloned = nextList.clone();
    let curListCloned = curList.clone();
    nextList.replaceWith(curListCloned);
    curList.replaceWith(nextListCloned);
  }
}
$(document).on("click", "button.btn_up", changeOrder);
$(document).on("click", "button.btn_down", changeOrder);

// 第六步：重要性的星號
// 點擊星號的時候，該星號加上 -on 這個 class，然後該筆待辦事項，星號數( data-star )小於等於點擊的星號數的話，也要加上 -on 這個 class；反之則移除。

$(document).on("click", "span.star", function () {
  let curData = $(this).attr("data-star");
  let stars = $(this).closest("div.star_block").find("span.star");

  stars.each(function (i, item) {
    if ($(item).attr("data-star") <= curData) $(item).addClass("-on");
    else $(item).removeClass("-on");
  });
});
