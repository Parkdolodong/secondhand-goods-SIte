$(document).ready(function () {
    $('#end-time').timepicker({
        timeFormat: 'HH:mm',
        interval: 60,
        startTime: '00:00',
        dynamic: false,
        dropdown: true,
        scrollbar: true
    });
    
    const today = new Date();
    const minDate = new Date(today.getFullYear(), today.getMonth(), today.getDate() + 2);
    const minDateISO = minDate.toISOString().split("T")[0];
  
    // input 요소의 min 속성 값을 현재 날짜로 설정합니다.
    document.getElementById("end-date").min = minDateISO;
});
function previewImage(event) {
    const preview = document.getElementById('image');
    const file = event.target.files[0];
    const reader = new FileReader();
    reader.onloadend = () => {
      preview.src = reader.result;
    }
    if (file) {
      reader.readAsDataURL(file);
    } else {
      preview.src = "";
    }
  }