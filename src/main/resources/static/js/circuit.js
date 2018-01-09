$(document).ready(function() {
  $("#spinner").hide();
  $(document).on("click", "#dateTime", function() {
    $("#spinner").show();
    $.get({
      url: "date",
      cache: false,
      success: function(resp) {
        $("#placeholder").text("");
        $("#placeholder").text("The current date/time is " + resp.month + " " + resp.dayOfMonth + ", " + resp.year + " " + resp.hour + ":" + resp.minute + ":" + resp.second);
        $("#spinner").hide();
      }
    });

  });

});

