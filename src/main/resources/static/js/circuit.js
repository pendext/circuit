$(document).ready(function() {
  $(document).on("click", "#dateTime", function() {
    $("#spinner").css("visibility", "visible");
    $.get({
      url: "date",
      cache: false,
      success: function(resp) {
        $("#placeholder").text("");
        $("#placeholder").text("The current date/time is " + resp.month + " " + resp.dayOfMonth + ", " + resp.year + " " + resp.hour + ":" + resp.minute + ":" + resp.second);
        $("#spinner").css("visibility", "hidden");
      }
    });

  });

});

