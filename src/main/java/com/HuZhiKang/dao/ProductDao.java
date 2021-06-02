package com.HuZhiKang.dao;

import com.HuZhiKang.model.Product;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements  IProductDao{
    @Override
    public int save(Product product, Connection con) throws SQLException {
        int n = 0;
        String sql = "insert into product(ProductName,ProductDescription,Picture,price,CategoryID) values(?,?,?,?,?)";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setString(1, product.getProductName());
        pt.setString(2, product.getProductDescription());
        if(product.getPicture()!=null) {
            //for sql server
            pt.setBinaryStream(3, product.getPicture());
            //for mysql
            //   pt.setBlob(3, product.getPicture());
        }
        pt.setDouble(4, product.getPrice());
        pt.setInt(5, product.getCategoryId());
        n = pt.executeUpdate();
        if (n > 0) {
            return n;
        }
        return 0;
    }//end save

    @Override
    public int delete(Integer productId, Connection con) throws SQLException {
        String sql ="delete from Product where ProductId=?";
        PreparedStatement p=con.prepareStatement(sql);
        p.setInt(1,productId);
        int i=p.executeUpdate();
        if(i>0){
            return 1;
        }else
        return 0;
    }

    @Override
    public int update(Product instance, Connection con) throws SQLException {
        String sql ="update Product set ProductName=?,ProductDescription=?,Picture=?,Price=?,CategoryId=? where ProductId=?";
        PreparedStatement p=con.prepareStatement(sql);
        p.setString(1, instance.getProductName());
        p.setString(2, instance.getProductDescription());
        if(instance.getPicture()!=null) {
            //for sql server
            p.setBinaryStream(3, instance.getPicture());
            //for mysql
            //   pt.setBlob(3, product.getPicture());
        }
        p.setDouble(4, instance.getPrice());
        p.setInt(5, instance.getCategoryId());
        p.setInt(6,instance.getProductId());
        int i=p.executeUpdate();
        if(i>0){
            return 1;
        }else
        return 0;
    }

    @Override
    public Product findById(Integer productId, Connection con) throws SQLException {
        String sql = "select * from Product where ProductId = ?";
        PreparedStatement p=con.prepareStatement(sql);
        p.setInt(1,productId);
        ResultSet rs =p.executeQuery();
        Product product=null;
        if(rs.next()){
            product=new Product();
            product.setProductId(rs.getInt("ProductId"));
            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
            product.setPicture(rs.getBinaryStream("Picture"));
            product.setPrice(rs.getDouble("Price"));
            product.setCategoryId(rs.getInt("CategoryId"));
        }
        return product;
    }

    @Override
    public List<Product> findByCategoryId(int categoryId, Connection con) throws SQLException {
        List<Product> productList = new ArrayList<Product>();
        String sql = "select * from Product where CategoryId=?";
            PreparedStatement p=con.prepareStatement(sql);
            p.setInt(1,categoryId);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                Product product=new Product();
                product.setProductId(rs.getInt("ProductId"));
                product.setProductName(rs.getString("ProductName"));
                product.setProductDescription(rs.getString("ProductDescription"));
                product.setPicture(rs.getBinaryStream("Picture"));
                product.setPrice(rs.getDouble("Price"));
                product.setCategoryId(rs.getInt("CategoryId"));
                productList.add(product);

        }
        return productList;
    }

    @Override
    public List<Product> findByPrice(double minPrice, double maxPrice, Connection con) throws SQLException {
        List<Product> productList = new ArrayList<Product>();
        String sql = "select * from Product where Price=?";
        PreparedStatement p=con.prepareStatement(sql);
        p.setDouble(1,maxPrice);
        ResultSet rs = p.executeQuery();
        while (rs.next()) {
            Product product=new Product();
            product.setProductId(rs.getInt("ProductId"));
            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
            product.setPicture(rs.getBinaryStream("Picture"));
            product.setPrice(rs.getDouble("Price"));
            product.setCategoryId(rs.getInt("CategoryId"));
            productList.add(product);
        }
        return productList;
    }

    @Override
    public List<Product> findAll(Connection con) throws SQLException {
        List<Product> productList = new ArrayList<Product>();
        String sql = "select * from Product";
        PreparedStatement p=con.prepareStatement(sql);
        ResultSet rs = p.executeQuery();
        while (rs.next()) {
            Product product=new Product();
            product.setProductId(rs.getInt("ProductId"));
            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
            product.setPicture(rs.getBinaryStream("Picture"));
            product.setPrice(rs.getDouble("Price"));
            product.setCategoryId(rs.getInt("CategoryId"));
            productList.add(product);

        }
        System.out.println("successful");
        return productList;
    }

    @Override
    public List<Product> findByProductName(String productName, Connection con) throws SQLException {
        List<Product> productList = new ArrayList<Product>();
        String sql = "select * from Product where ProductName=?";
        PreparedStatement p=con.prepareStatement(sql);
        p.setString(1,productName);
        ResultSet rs = p.executeQuery();
        while (rs.next()) {
            Product product=new Product();
            product.setProductId(rs.getInt("ProductId"));
            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
            product.setPicture(rs.getBinaryStream("Picture"));
            product.setPrice(rs.getDouble("Price"));
            product.setCategoryId(rs.getInt("CategoryId"));
            productList.add(product);

        }
        return productList;
    }

    @Override
    public List<Product> getPicture(Integer productId, Connection con) throws SQLException {
        List<Product> productList = new ArrayList<Product>();
        String sql = "select Picture from Product where ProductId=?";
        PreparedStatement p=con.prepareStatement(sql);
        p.setInt(1,productId);
        ResultSet rs = p.executeQuery();
        while (rs.next()) {
            Product product=new Product();
            product.setProductId(rs.getInt("ProductId"));
            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
            product.setPicture(rs.getBinaryStream("Picture"));
            product.setPrice(rs.getDouble("Price"));
            product.setCategoryId(rs.getInt("CategoryId"));
            productList.add(product);

        }
        return productList;
    }
    public byte[] getPictureById(Integer productId,Connection con) throws SQLException {
        byte[] imgBytes=null;
        String sql="select picture from product where productId=?";
        PreparedStatement pt=con.prepareStatement(sql);
        pt.setInt(1,productId);
        ResultSet rs=pt.executeQuery();
        while (rs.next()){
            Blob blob=rs.getBlob("picture");
            imgBytes=blob.getBytes(1,(int)blob.length());//get all
        }
        return imgBytes;
    }
}
