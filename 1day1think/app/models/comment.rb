class Comment < ApplicationRecord
    belongs_to :news
    belongs_to :user
    has_many :likes
end
