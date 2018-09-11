# This file is auto-generated from the current state of the database. Instead
# of editing this file, please use the migrations feature of Active Record to
# incrementally modify your database, and then regenerate this schema definition.
#
# Note that this schema.rb definition is the authoritative source for your
# database schema. If you need to create the application database on another
# system, you should be using db:schema:load, not running all the migrations
# from scratch. The latter is a flawed and unsustainable approach (the more migrations
# you'll amass, the slower it'll run and the greater likelihood for issues).
#
# It's strongly recommended that you check this file into your version control system.

ActiveRecord::Schema.define(version: 20180830124436) do

  create_table "comments", force: :cascade do |t|
    t.integer  "like_count"
    t.text     "contents"
    t.integer  "category"
    t.integer  "News_id"
    t.integer  "Users_id"
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
    t.index ["News_id"], name: "index_comments_on_News_id"
    t.index ["Users_id"], name: "index_comments_on_Users_id"
  end

  create_table "likes", force: :cascade do |t|
    t.integer "Users_id"
    t.integer "Comment_id"
    t.index ["Comment_id"], name: "index_likes_on_Comment_id"
    t.index ["Users_id"], name: "index_likes_on_Users_id"
  end

  create_table "news", force: :cascade do |t|
    t.text     "contents"
    t.string   "category"
    t.integer  "comment_num"
    t.string   "title"
    t.text     "link"
    t.datetime "created_at",  null: false
    t.datetime "updated_at",  null: false
    t.text     "positive"
    t.text     "negative"
    t.text     "neutral"
    t.string   "opinion"
  end

  create_table "users", force: :cascade do |t|
    t.string   "name"
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
    t.boolean  "category1"
    t.boolean  "category2"
    t.boolean  "category3"
    t.boolean  "category4"
    t.boolean  "category5"
    t.boolean  "category6"
    t.boolean  "category7"
  end

end
