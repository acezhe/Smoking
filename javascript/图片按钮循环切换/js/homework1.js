var circleSwitch = true;
var picNum = 1;

function switchChange(type) {
    if ("circle" === type) {
        oCircle.style.backgroundColor = "#777";
        oCircle.style.border = "1px inset #333";
        oUnidirection.style.removeProperty("border");
        oUnidirection.style.removeProperty("background-color");
        circleSwitch = true;
    } else {
        oUnidirection.style.backgroundColor = "#777";
        oUnidirection.style.border = "1px inset #333";
        oCircle.style.removeProperty("border");
        oCircle.style.removeProperty("background");
        circleSwitch = false;
    }
}

function pictureSwitch(direction) {
    if ("next" === direction) {
        if (circleSwitch) {
            if (picNum == 6) {
                picNum = 0;
            }
            picNum += 1;
            oContent.style.backgroundImage = "url(./images/" + picNum + ".jpg)";
            barSwitch(picNum);
        } else {
            if (picNum == 6) {
                alert("最后一张图片了~囧~")
            } else {
                picNum += 1;
                oContent.style.backgroundImage = "url(./images/" + picNum + ".jpg)";
                barSwitch(picNum);
            }
        }
    } else if ("preview" === direction) {
        if (circleSwitch) {
            if (picNum == 1) {
                picNum = 7;
            }
            picNum -= 1;
            oContent.style.backgroundImage = "url(./images/" + picNum + ".jpg)";
            barSwitch(picNum);
        } else {
            if (picNum == 1) {
                alert("最后一张图片了~囧~")
            } else {
                picNum -= 1;
                oContent.style.backgroundImage = "url(./images/" + picNum + ".jpg)";
                barSwitch(picNum);
            }
        }
    } else {
        oContent.style.backgroundImage = "url(./images/1.jpg)";
        barSwitch(picNum);
    }
}

function barSwitch(picNum) {
    switch (picNum) {
        case 1: {
            oHeader_bar.innerHTML = "1/6";
            oFooter_bar.innerHTML = "第一张图片";
            break;
        }
        case 2: {
            oHeader_bar.innerHTML = "2/6";
            oFooter_bar.innerHTML = "第二张图片";
            break;
        }
        case 3: {
            oHeader_bar.innerHTML = "3/6";
            oFooter_bar.innerHTML = "第三张图片";
            break;
        }
        case 4: {
            oHeader_bar.innerHTML = "4/6";
            oFooter_bar.innerHTML = "第四张图片";
            break;
        }
        case 5: {
            oHeader_bar.innerHTML = "5/6";
            oFooter_bar.innerHTML = "第五张图片";
            break;
        }
        case 6: {
            oHeader_bar.innerHTML = "6/6";
            oFooter_bar.innerHTML = "第六张图片";
            break;
        }
        default: {
            oHeader_bar.innerHTML = "1/6";
            oFooter_bar.innerHTML = "第一张图片";
        }
    }
}
