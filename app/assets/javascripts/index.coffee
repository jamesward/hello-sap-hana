$ ->
  $.get "/psa-transactions", (data) ->
    t = $("<table>").addClass("table")
    thr = $("<tr>")
    thr.append($("<th>").text("ID"))
    thr.append($("<th>").text("Description"))
    thr.append($("<th>").text("Category"))
    thr.append($("<th>").text("Amount"))
    t.append($("<thead>").append(thr))
    $.each data, (index, item) ->
      row = $("<tr>")
      row.append($("<td>").text(item.id))
      row.append($("<td>").text(item.description))
      row.append($("<td>").text(item.category))
      row.append($("<td>").text(item.amount))
      t.append(row)
    console.log(t)
    $(".well").children().replaceWith(t)