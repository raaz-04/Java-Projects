/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.layerd.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import pos.layerd.dao.CrudUtil;
import pos.layerd.dao.custom.ItemDao;
import pos.layerd.entity.ItemEntity;

/**
 *
 * @author DELL i5
 */
public class ItemDaoImpl implements ItemDao {

    @Override
    public boolean add(ItemEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO item VALUES (?,?,?,?,?)",
                t.getId(),
                t.getDescription(),
                t.getPackSize(),
                t.getUnitPrice(),
                t.getQoh());
    }

    @Override
    public boolean update(ItemEntity t) throws Exception {
        return CrudUtil.executeUpdate("UPDATE item SET description=?, packSize=?, unitPrice=?, quantityOnHand=? WHERE itemCode = ?", 
                t.getDescription(),
                t.getPackSize(),
                t.getUnitPrice(),
                t.getQoh(),
                t.getId());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM item WHERE itemCode = ?", id);
    }

    @Override
    public ItemEntity get(String id) throws Exception {
        ResultSet rs = CrudUtil.executeQuery("SELECT * FROM item WHERE itemCode = ?", id);
        while (rs.next()) {
            return new ItemEntity(
                    rs.getString(1), 
                    rs.getString(2), 
                    rs.getString(3), 
                    rs.getDouble(4), 
                    rs.getInt(5));
        }
        return null;
    }

    @Override
    public ArrayList<ItemEntity> getAll() throws Exception {
        ArrayList<ItemEntity> itemEntitys = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM item");
        while (rst.next()) {
            ItemEntity entity = new ItemEntity(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getDouble(4),
                    rst.getInt(5));
            itemEntitys.add(entity);
        }
        return itemEntitys;
    }

}
