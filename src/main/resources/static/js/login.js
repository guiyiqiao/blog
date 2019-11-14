function Submit(){
    var email=$("#email").val();
    if(email=="root"){
        email = email+"@126.com";
    }
    //console.log(email);
    var password=$("#password").val();
    var captcha =$("#captcha").val();
    var data={
            "email": email,
            "password": password,
            "captcha":captcha
    }
    $.ajax({
        type: "POST", //请求的方式，默认get请求
        url: "/login", //请求地址，后台提供的
        data: JSON.stringify(data) ,
        contentType: 'application/json',//如果添加contentType那么传到后台的就必须是json字符串
        dataType: "json", //json格式，如果后台返回的数据为json格式的数据，那么前台会收到Object。

        success: function(result){
            //console.log(result);
            if(result.rtnCode == 1){
               window.location.href="/"
            }else{
                document.getElementById("error-text").innerHTML = result.message;
            }
        }
    })
};
function toEnroll() {  //"captcha":captcha
    window.location.href="/toEnroll";
}