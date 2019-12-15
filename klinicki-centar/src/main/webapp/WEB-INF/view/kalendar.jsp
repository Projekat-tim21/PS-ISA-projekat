<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8' />
<base href="/">
<link href='package/core/main.css' rel='stylesheet' />
<link href='package/daygrid/main.css' rel='stylesheet' />
<link href='package/timegrid/main.css' rel='stylesheet' />
<link href='packages-premium/timeline/main.css' rel='stylesheet' />
<link href='packages-premium/resource-timeline/main.css' rel='stylesheet' />
<script src='package/core/main.js'></script>
<script src='package/interaction/main.js'></script>
<script src='package/daygrid/main.js'></script>
<script src='package/timegrid/main.js'></script>
<script src='packages-premium/timeline/main.js'></script>
<script src='packages-premium/resource-common/main.js'></script>
<script src='packages-premium/resource-timeline/main.js'></script>
<script>

  document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendar');

    var calendar = new FullCalendar.Calendar(calendarEl, {
      plugins: [ 'interaction', 'dayGrid', 'timeGrid', 'resourceTimeline' ],
      now: '2019-08-07',
      editable: true, // enable draggable events
      aspectRatio: 1.8,
      scrollTime: '00:00', // undo default 6am scrollTime
      header: {
        left: 'today prev,next',
        center: 'title',
        right: 'resourceTimelineDay,resourceTimelineThreeDays,timeGridWeek,dayGridMonth'
      },
      defaultView: 'resourceTimelineDay',
      views: {
        resourceTimelineThreeDays: {
          type: 'resourceTimeline',
          duration: { days: 3 },
          buttonText: '3 days'
        }
      },
      resourceLabelText: 'Rooms',
      resources: [
        { id: 'a', title: 'Auditorium A' },
        { id: 'b', title: 'Auditorium B', eventColor: 'green' },
        { id: 'c', title: 'Auditorium C', eventColor: 'orange' },
        { id: 'd', title: 'Auditorium D', children: [
          { id: 'd1', title: 'Room D1' },
          { id: 'd2', title: 'Room D2' }
        ] },
        { id: 'e', title: 'Auditorium E' },
        { id: 'f', title: 'Auditorium F', eventColor: 'red' },
        { id: 'g', title: 'Auditorium G' },
        { id: 'h', title: 'Auditorium H' },
        { id: 'i', title: 'Auditorium I' },
        { id: 'j', title: 'Auditorium J' },
        { id: 'k', title: 'Auditorium K' },
        { id: 'l', title: 'Auditorium L' },
        { id: 'm', title: 'Auditorium M' },
        { id: 'n', title: 'Auditorium N' },
        { id: 'o', title: 'Auditorium O' },
        { id: 'p', title: 'Auditorium P' },
        { id: 'q', title: 'Auditorium Q' },
        { id: 'r', title: 'Auditorium R' },
        { id: 's', title: 'Auditorium S' },
        { id: 't', title: 'Auditorium T' },
        { id: 'u', title: 'Auditorium U' },
        { id: 'v', title: 'Auditorium V' },
        { id: 'w', title: 'Auditorium W' },
        { id: 'x', title: 'Auditorium X' },
        { id: 'y', title: 'Auditorium Y' },
        { id: 'z', title: 'Auditorium Z' }
      ],
      events: [

        // background event, associated with a resource
        { id: 'bg1', resourceId: 'b', rendering: 'background', start: '2019-08-07T01:00:00', end: '2019-08-07T04:00:00' },

        // background event, NOT associated with a resource
        { id: 'bg2', rendering: 'background', start: '2019-08-07T05:00:00', end: '2019-08-07T08:00:00' },

        // normal events...
        { id: '1', resourceId: 'b', start: '2019-08-07T02:00:00', end: '2019-08-07T07:00:00', title: 'event 1' },
        { id: '2', resourceId: 'c', start: '2019-08-07T05:00:00', end: '2019-08-07T22:00:00', title: 'event 2' },
        { id: '3', resourceId: 'd', start: '2019-08-06', end: '2019-08-09', title: 'event 3' },
        { id: '4', resourceId: 'e', start: '2019-08-07T03:00:00', end: '2019-08-07T08:00:00', title: 'event 4' },
        { id: '5', resourceId: 'f', start: '2019-08-07T00:30:00', end: '2019-08-07T02:30:00', title: 'event 5' }
      ]
    });

    calendar.render();
  });

</script>
<style>

  body {
    margin: 0;
    padding: 0;
    font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
    font-size: 14px;
  }

  #calendar {
    max-width: 900px;
    margin: 50px auto;
  }

</style>
</head>
<body>

  <div id='calendar'></div>

</body>
</html>