class CreateComments < ActiveRecord::Migration[5.0]
  def change
    create_table :comments do |t|
      t.integer :like_count
      t.text :contents
      t.integer :category
      t.belongs_to 	:News
      t.belongs_to :Users
      t.timestamps
    end
  end
end
