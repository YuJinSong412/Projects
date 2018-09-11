class CreateNews < ActiveRecord::Migration[5.0]
  def change
    create_table :news do |t|
      t.text :contents
      t.string :category
      t.integer :comment_num
      t.string :title
      t.text :link
      t.timestamps
      t.text :positive
      t.text :negative
      t.text :neutral
      t.string :opinion
    end
  end
end
