<%-- 
    Document   : adminReplyForum
    Created on : Jan 16, 2022, 9:45:26 PM
    Author     : Mhdrfq
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reply Forum</title>
        <jsp:include page="includes/head.jsp"/>
    </head>
    <body>
        <jsp:include page="includes/adminNavbar.jsp"/>
        <main>
        <div class="container-fluid">
            <form method="post" action="updateForum"> 
                <div class="col-sm-6 mb-3 mt-5 mb-4">
                    <h4>Reply to Forum</h4>
                </div>
                
                <input type="hidden" name="eid" value="${entry.id}">
    
                <div class="col-sm-6 mb-3">
                    <label for="topic" class="form-label">Topic</label>
                    <input type="text" name="topic" class="form-control" id="topic" placeholder="${entry.topic}" disabled>
                </div>
    
                <div class="col-sm-6 mb-3">
                    <label for="message" class="form-label">Message</label>
                    <textarea rows="4" name="message" class="form-control" id="message" placeholder="${entry.message}" disabled></textarea>
                </div>
    
                <div class="col-sm-6 mb-3">
                    <label for="reply" class="form-label">Reply</label>
                    <textarea rows="4" name="reply" class="form-control" id="reply" placeholder="${entry.reply}" required></textarea>
                </div>

                <div class="col-sm-2 mb-3 mt-5">
                    <a href="adminViewForum" class="btn btn-secondary px-4" type="submit" value="submit">Back</a>
                    <button class="btn btn-success px-4" type="submit" value="submit">Submit</button>
                </div>
                
            </form>

        </div>
        </main>
    </body>
</html>
