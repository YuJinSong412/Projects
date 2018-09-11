class CommentController < ApplicationController
    
    def comment
        @num = params[:id]
        @token = form_authenticity_token
        #News들 가운데 id값을 받아서 하나를 선택
        @new = News.find @num
        #해당 뉴스의 commet들을 전부 comment변수에 담음
        @comment = @new.comments
        
        
    end
    
    def like_toggle
        like = Like.find_by(users_id: 1, comment_id: params[:post_id])
        #좋아요가 눌렸는지 체크
        if like.nil?
          Like.create(Users_id: 1, Comment_id: params[:post_id])
        else
          like.destroy
        end
        redirect_to :back
    end
      
    def pos_comment
        @num = params[:id]
       @token = form_authenticity_token
        #News들 가운데 id값을 받아서 하나를 선택
       @new = News.find params[:id]
        #해당 뉴스의 commet들을 전부 comment변수에 담음
       @comment = @new.comments
    end
    
    def neu_comment
        @num = params[:id]
       @token = form_authenticity_token
        #News들 가운데 id값을 받아서 하나를 선택
       @new = News.find params[:id]
        #해당 뉴스의 commet들을 전부 comment변수에 담음
       @comment = @new.comments
    end
    
    def con_comment
        @num = params[:id]
       @token = form_authenticity_token
        #News들 가운데 id값을 받아서 하나를 선택
       @new = News.find params[:id]
        #해당 뉴스의 commet들을 전부 comment변수에 담음
       @comment = @new.comments
    end
        
end
