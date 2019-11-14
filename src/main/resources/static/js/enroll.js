function enroll(){
    var email = $("#email").val();
    var password = $("#password").val();
    var nickname = $("#nickname").val();
    var data={
        "email": email,
        "password": password,
        "nickname":nickname
    }
    $.ajax({
        type: "POST", //请求的方式，默认get请求
        url: "/enroll", //请求地址，后台提供的
        data: JSON.stringify(data) ,
        contentType: 'application/json',//如果添加contentType那么传到后台的就必须是json字符串
        dataType: "json", //json格式，如果后台返回的数据为json格式的数据，那么前台会收到Object。
        success: function(result){
            if(result.code == 1){
                window.location="/";
            }else {
                document.getElementById("error").innerHTML = result.message;
            }
        }
    })
};
function toLogin() {
    window.location.href="/toLogin";
}
function toIndex() {
    window.location.href="/";
}