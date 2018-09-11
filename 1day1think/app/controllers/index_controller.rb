class IndexController < ApplicationController
    
    def category
        
    end
    
    def loading
        user = User.find 1
        list = Array.new
        
        if params[:category7] == "True"
            user.category7 = true
            user.save
            list = ["1","2","3","4","5","6"]
        
        else
            user.category7 = false
             if params[:category1] == "True"
                user.category1 = true
                user.save
                list.push("1")
            else
                user.category1 = false
            end
            
            if params[:category2] == "True"
                user.category2 = true
                user.save
                list.push("2")
            else
                user.category2 = false
            end
            
            if params[:category3] == "True"
                user.category3 = true
                user.save
                list.push("3")
            else
                user.category3 = false
            end
            
            if params[:category4] == "True"
                user.category4 = true
                user.save
                list.push("4")
            else
                user.category4 = false
            end
            
            if params[:category5] == "True"
                user.category5 = true
                user.save
                list.push("5")
            else
                user.category5 = false
            end
            
            if params[:category6] == "True"
                user.category6 = true
                user.save
                list.push("6")
            else
                user.category6 = false
            end
        end
        
        if list == []
            user.category7 = true
            user.save
            list = ["1","2","3","4","5","6"]
        end
        
        num = list.sample
        news = News.find_by(category: num)
        
        redirect_to "/index/#{news.id}"
        
    end
    
    def index 
        news = News.find params[:id]
        @contents = news.contents
        @link = news.link
        @num = params[:id]
        if news.opinion == "positive"
            @opi = news.positive
            @n1="active"
            @n2="x"
            @n3="x"
            #긍정일 경우, @n1(긍정)만 active 속성값 부여
        elsif news.opinion == "negative"
            @opi = news.negative
            @n1="x"
            @n2="x"
            @n3="active"
            #부정일 경우, @n3(부정)만 active 속성값 부여
        elsif news.opinion == "neutral"
            @opi = news.neutral
            @n1="x"
            @n2="active"
            @n3="x"
            #중립일 경우, @n2(중립)만 active 속성값 부여
        else
            @opi = news.positive
        end
            
    end
    
    def opi1
        @num = params[:id]
        news = News.find @num
        news.opinion = "positive"
        news.save
        redirect_to :back
    end
    
    def opi2
        @num = params[:id]
        news = News.find @num
        news.opinion = "neutral"
        news.save
        redirect_to :back
    end
    
    def opi3
        @num = params[:id]
        news = News.find @num
        news.opinion = "negative"
        news.save
        redirect_to :back
    end
    
    def link
        news = News.find params[:id]
        @link = news.link
        
        redirect_to @link
    end
    
end


