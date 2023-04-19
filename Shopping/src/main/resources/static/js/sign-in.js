$(document).ready(function () {
  $("form").submit(function (event) {
    // 서버로 전송할 데이터를 객체 형태로 생성합니다.
    event.preventDefault();
    var data = {
      id: $("#id").val(),
      password: $("#password").val(),
    };

    console.log(data);
    // 서버로 ajax 요청을 보냅니다.
    $.ajax({
      url: "/sign/login",
      type: "POST",
      contentType: "application/json",
      data: JSON.stringify(data),
      dataType: "json",
      success: function (response) {
        console.log(response);
        window.location.href = "/";
        console.log("성공");
      },
      error: function (xhr, equest, status, error) {
        console.log(error);
        console.log("실패");
        window.location.href = "/sign/sign-in";
        alert(xhr.responseText);
      },
    });
  });
});

//$("#signupbutton").click(function() {
//    var userDto = {
//        "id": $("#id").val(),
//        "password": $("#password").val(),
//        "name": $("#name").val(),
//        "email": $("#email").val(),
//        "phoneNumber": $("#phonenumber").val(),
//        "userAddressDto": {
//            "address": $("#address").val(),
//            "zonecode": $("#postcode").val(),
//            "detailedaddress": $("#detailAddress").val()
//        }
//    };
//    $.ajax({
//        url: "/sign/register",
//        type: "POST",
//        contentType: "application/json",
//        data: JSON.stringify(userDto),
//        success: function(response) {
//            console.log("요청성공");
//            window.location.href = "/sign/sign-in";
//            alert("회원가입이 완료되었습니다.");
//            $('form :input').val('');
//        },
//        error: function(xhr, textStatus, errorThrown) {
//            console.log("에러발생", errorThrown);
//            alert(xhr.responseText);
//        }
//    });
//});
