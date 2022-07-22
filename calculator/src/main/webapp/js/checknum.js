// 验证用户的输入是否为空
function checkNum() {
    var num1 = document.getElementById("num1").value;
    var num2 = document.getElementById("num2").value;

    if(num1=="" || num2==""){
        window.alert("输入不能为空");
        return false;
    }

    var reg = /^[1-9]\d*(\.[0-9]+)?$|^0$/i;
    if(!reg.test(num1) || !reg.test(num2)){
        window.alert("输入不是数字");
        return false;
    }
    // if(!reg.test(num1)){
    //     window.alert("num1 不是数字");
    //     return false;
    // }
    // if(!reg.test(num2)){
    //     window.alert("num2 不是数字");
    //     return false;
    // }


}