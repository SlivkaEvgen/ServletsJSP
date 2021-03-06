<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name='DC.Language' scheme='rfc1766' content='ru'/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Skills</title>
    <jsp:include page="../homeView.jsp"></jsp:include>
</head>
<body>
<div class="w3-container w3-center w3-round">
    <div class="w3-container w3-center w3-round w3-text-hover-light-blue fa fa-remove">
        <h2 style="color:lightskyblue" class="text w3-animate-fading">Skills</h2>
    </div>
    <a href="addNewSkill" class="w3-btn w3-hover-light-blue w3-round-xlarge w3-center">Add New Skill</a>
    <label for="myInput"></label><input class="w3-input w3-border w3-hover-light-blue w3-round-xlarge" type="text"
                                        placeholder="Search for id..." id="myInput" onkeyup="myFunction()">
    <table class="w3-padding 16 w3-hoverable w3-table-all w3-card-4 w3-small w3-margin-top w3-round w3-centered w3-animate-opacity"
           id="myTable">
        <tr>
            <th>ID</th>
            <th>Activity</th>
            <th>Level</th>
            <th>Update</th>
            <th>Delete</th>
        </tr>
        <c:forEach items="${skillList}" var="skill">
            <tr>
                <td>${skill.id}</td>
                <td>${skill.activity}</td>
                <td>${skill.level}</td>
                <td>
                    <a href="updateSkill?id=${skill.id}" class="w3-btn w3-hover-light-blue w3-round-xlarge">Update</a>
                </td>
                <td>
                    <a href="deleteSkill?id=${skill.id}" class="w3-btn w3-hover-red w3-round-xlarge">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <div>
        <h4 style="text-align-all: center" class="text w3-red w3-round w3-margin-top w3-center">
            <c:out value="${error}" default=""></c:out>
        </h4>
    </div>
    <div>
        <h4 style="text-align-all: center; background-color:skyblue" class="text w3-round w3-margin-top w3-center">
            <c:out value="${error2}" default=""></c:out>
        </h4>
    </div>
</div>
</body>
<jsp:include page="/WEB-INF/view/_footer.jsp"></jsp:include>
</html>
<script>
    function myFunction() {
        var input, filter, table, tr, td, i;
        input = document.getElementById("myInput");
        filter = input.value.toUpperCase();
        table = document.getElementById("myTable");
        tr = table.getElementsByTagName("tr");
        for (i = 0; i < tr.length; i++) {
            td = tr[i].getElementsByTagName("td")[0];
            if (td) {
                txtValue = td.textContent || td.innerText;
                if (txtValue.toUpperCase().indexOf(filter) > -1) {
                    tr[i].style.display = "";
                } else {
                    tr[i].style.display = "none";
                }
            }
        }
    }
</script>
