/*jslint devel: true */
/* eslint-disable no-console */
/*eslint no-undef: "error"*/
/*eslint-env node*/

$(document).ready( function() { 
    
    /*DB생성 및 오픈, 테이블 생성 트랜잭션 실행*/
    openDB();
    createTable();
    
    /*회원가입 입력 트랜잭션 실행*/
    $('#submit').click(function(){
        insertMember();
    });
    
    /*로그인*/
    $('#submit1').click(function(){
        var id=$('#name1').val();
        var password=$('#password1').val();
        listMember(id,password);
    });
    
        $.ajax({
            url: 'list.xml',
            type: 'get',
            dataType: 'xml',
            timeout: 10000,
            success: function(xmlData) {
                //리스트뷰 
                var tagList = ""; 
                var index=0;
                
                //리스트뷰 관련 내용 가져오기
                $(xmlData).find('list').each(function(){
                    index++;
                    tagList += "<li id=a"+index+"><a href='#page3'>" + $(this).find('name'+index).text() + "</a></li>";
                    console.log(tagList);
                    
                });
                $('#listArea').empty(); 
                $('#listArea').append(tagList); 
                $('#listArea').listview('refresh');
                
                
                //각 버튼 누르면 page3 내용 가져오기 (전체 행정부서 가져옴)
                $('#a1').click(function(){
                    
                    //전체 행정부서 가져오기
                    var name1="<div class='ui-bar'><img src='administration.png'>"+$(xmlData).find('name1').text()+"</div>"
                    console.log(name1);
                    $('.ui-bar').html(name1);
                    
                    //제목(대학일자리센터) 가져오기 
                    var title1="<h4>"+$(xmlData).find('title1').text()+"</h4>";
                    $('.h4').html(title1);
                    
                    var systemImg1="<div class='systemImg'><img src='f4.jpeg'></div>"
                    $('.systemImg').html(systemImg1);
                    
                    var summary1="<p class='summary1'>"+$(xmlData).find('summary1').text()+"</p>";
                    $('.summary1').html(summary1);    
                });
                
                //각 버튼 누르면 page3 내용 가져오기 (전체 단과대학 가져옴)
                $('#a2').click(function(){
                    
                    //전체 단과대학 가져오기
                    var name2="<div class='ui-bar'><img src='administration.png'>"+$(xmlData).find('name2').text()+"</div>"
                    console.log(name2);
                    $('.ui-bar').html(name2);
                    
                    //제목(바이오나노대학) 가져오기 
                    var title2="<h4>"+$(xmlData).find('title2').text()+"</h4>";
                    $('.h4').html(title2);
                    
                    var systemImg2="<div class='systemImg'><img src='f1.jpeg' width='50%'></div>"
                    $('.systemImg').html(systemImg2);
                    
                    console.log(systemImg2);
                    
                    //내용 요약본 가져오기 
                    var summary2="<p class='summary1'>"+$(xmlData).find('summary2').text()+"</p>";
                    $('.summary1').html(summary2);    
                });
                
                //각 버튼 누르면 page3 내용 가져오기 (전체 분류 가져옴)
                $('#a3').click(function(){
                    
                    //전체 분류 가져오기
                    var name3="<div class='ui-bar'><img src='administration.png'>"+$(xmlData).find('name3').text()+"</div>"
                    console.log(name3);
                    $('.ui-bar').html(name3);
                    
                    //제목(바이오나노대학) 가져오기 
                    var title3="<h4>"+$(xmlData).find('title3').text()+"</h4>";
                    $('.h4').html(title3);
                    
                    var systemImg3="<div class='systemImg'><img src='f3.jpeg'></div>"
                    $('.systemImg').html(systemImg3);
                    
                    //내용 요약본 가져오기 
                    var summary3="<p class='summary1'>"+$(xmlData).find('summary3').text()+"</p>";
                    $('.summary1').html(summary3);    
                });
        
            
            },
            error: function(a) {
                $("#listArea").html("<p>Error!!</p>"); 
            }
        });
    

});