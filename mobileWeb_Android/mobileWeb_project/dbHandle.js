/*jslint devel: true */
/* eslint-disable no-console */
/*eslint no-undef: "error"*/
/*eslint-env node*/


var db=null;
var var_no=null;
var positioin=null;
var index;

/*DB생성 오픈*/
function openDB(){
    db=window.openDatabase('membershipDB','1,0','회원DB',1024*1024);
    console.log("DB생성");
}

/*테이블 생성*/
function createTable(){
    db.transaction(function(tr){
        var createSQL='create table if not exists membership(id text,password text,passwordcheck text,email text)';
        tr.executeSql(createSQL,[],function(){
        console.log("테이블 생성 실행 성공");
        });
    });
}

/*회원가입 절차(추가)*/
function insertMember(){
    db.transaction(function(tr){
        var id=$('#loginID').val();
        var password=$('#loginPW').val();
        var passwordcheck=$('#PWcheck').val();
        var email=$('#loginEmail').val();
        
        var insertSQL='insert into membership(id,password,passwordcheck,email) values(?,?,?,?)';
        tr.executeSql(insertSQL,[id,password,passwordcheck,email],function(tr,rs){
            console.log("회원등록");
            $('#loginID').val('');
            $('#loginPW').val('');
            $('#PWcheck').val('');
            $('#loginEmail').val('');
            
            alert(id+'님! 회원가입되었습니다!');
            location.href="#page1";

        },function(tr,err){
            alert("오류");
        }
        );
    });
}


/*로그인 절차(검색)*/
function listMember(id,password){
    db.transaction(function(tr){
        var selectSQL='select id,password from membership where id=? AND password=? ';
        tr.executeSql(selectSQL,[id,password],function(tr,rs){
            console.log('성공적');

            alert(id+'님이 로그인 되었습니다.');
            location.href="#page1";

        },function(tr,err){
            alert('error');
        }
        );
    });
}
