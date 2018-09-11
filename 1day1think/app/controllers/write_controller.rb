class WriteController < ApplicationController
    def pos_writeThink
        @num = params[:id]
         news = News.find @num
        @contents = news.contents
    end
    
    def neu_writeThink
        @num = params[:id]
        news = News.find @num
        @contents = news.contents
    end
    
    def con_writeThink
        @num = params[:id]
        news = News.find @num
        @contents = news.contents
    end
    
    def pos_create
        @num = params[:id]
        news = News.find @num
        comment = Comment.new
        #category = 1 => 긍정
        comment.category = '1'
        comment.contents = params[:comment]
        comment.News_id = params[:news_num]
        comment.Users_id = params[:user_num]
        comment.save
        
        redirect_to "/comment/#{@num}"
    end
    
    def neu_create
        @num = params[:id]
        news = News.find @num
        comment = Comment.new
         #category = 1 => 중립
        comment.category ='2'
        comment.contents = params[:comment]
        comment.News_id = params[:news_num]
        comment.Users_id = params[:user_num]
        comment.save
        
        redirect_to "/comment/#{@num}"
    end
    
    def con_create
        @num = params[:id]
        news = News.find @num
        
        comment = Comment.new
         #category = 1 => 부정
        comment.category = '3'
        comment.contents = params[:comment]
        comment.News_id = params[:news_num]
        comment.Users_id = params[:user_num]
        comment.save
        
        redirect_to "/comment/#{@num}"
    end
end



