class CreateUsers < ActiveRecord::Migration[5.0]
  def change
    create_table :users do |t|
      t.string :name
      t.timestamps
      t.boolean :category1
      t.boolean :category2
      t.boolean :category3
      t.boolean :category4
      t.boolean :category5
      t.boolean :category6
      t.boolean :category7

      
    end
  end
end
