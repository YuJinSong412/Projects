Rails.application.routes.draw do
  # For details on the DSL available within this file, see http://guides.rubyonrails.org/routing.html
  
  root 'index#category'
  get 'opi1/:id' => 'index#opi1'
  get 'opi2/:id' => 'index#opi2'
  get 'opi3/:id' => 'index#opi3'
  get 'write/pos/:id' => 'write#pos_writeThink'
  get 'write/neu/:id' => 'write#neu_writeThink'
  get 'write/con/:id' => 'write#con_writeThink'
  get 'link' => 'index#link'
  get 'comment/:id' => 'comment#comment'
  get 'comment/:post_id/like' => 'comment#like_toggle'
  get 'index/:id' => 'index#index'
  get 'index' => 'index#loading'
  get '/pos_create/:id' => 'write#pos_create'
  get '/neu_create/:id' => 'write#neu_create'
  get '/con_create/:id' => 'write#con_create'
  get 'comment/:id/pos' => 'comment#pos_comment'
  get 'comment/:id/neu' => 'comment#neu_comment'
  get 'comment/:id/con' => 'comment#con_comment'
end
