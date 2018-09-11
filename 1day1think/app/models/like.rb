class Like < ApplicationRecord
    belongs_to :comment,  polymorphic: true, optional: true
    belongs_to :user,  polymorphic: true, optional: true
    # Rails 5 makes belongs_to association required by default
    # notice :required is deprecated
end
