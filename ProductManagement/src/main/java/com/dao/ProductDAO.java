package com.dao;

import java.sql.*;
import java.util.*;
import com.model.Product;

public class ProductDAO {

    // ✅ COMMON CONNECTION METHOD (INSIDE SAME FILE)
    private static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/productdb",
            "root",
            "root"
        );
    }

    // ===================== ADD =====================
    public static int addProduct(Product p) {
        int status = 0;

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(
                "INSERT INTO Products VALUES (?, ?, ?, ?, ?)")) {

            ps.setInt(1, p.getProductID());
            ps.setString(2, p.getProductName());
            ps.setString(3, p.getCategory());
            ps.setDouble(4, p.getPrice());
            ps.setInt(5, p.getQuantity());

            status = ps.executeUpdate();

        } catch(Exception e) {
            e.printStackTrace();
        }

        return status;
    }
    public static List<Product> getAllProducts() {
        List<Product> list = new ArrayList<>();

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM Products");
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(mapRow(rs));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    // ===================== DELETE =====================
    public static int deleteProduct(int id) {
        int status = 0;

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(
                "DELETE FROM Products WHERE ProductID=?")) {

            ps.setInt(1, id);
            status = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    // ===================== UPDATE =====================
    public static int updateProduct(Product p) {
        int status = 0;

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(
                "UPDATE Products SET ProductName=?, Category=?, Price=?, Quantity=? WHERE ProductID=?")) {

            ps.setString(1, p.getProductName());
            ps.setString(2, p.getCategory());
            ps.setDouble(3, p.getPrice());
            ps.setInt(4, p.getQuantity());
            ps.setInt(5, p.getProductID());

            status = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    // ===================== FILTER: PRICE =====================
    public static List<Product> getProductsByPrice(double price) {
        List<Product> list = new ArrayList<>();

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM Products WHERE Price > ?")) {

            ps.setDouble(1, price);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(mapRow(rs));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // ===================== FILTER: CATEGORY =====================
    public static List<Product> getProductsByCategory(String category) {
        List<Product> list = new ArrayList<>();

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM Products WHERE Category = ?")) {

            ps.setString(1, category);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(mapRow(rs));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // ===================== TOP N PRODUCTS =====================
    public static List<Product> getTopProducts(int limit) {
        List<Product> list = new ArrayList<>();

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM Products ORDER BY Quantity DESC LIMIT ?")) {

            ps.setInt(1, limit);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(mapRow(rs));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // ===================== COMBINED FILTER =====================
    public static List<Product> getFilteredProducts(String category, double price) {
        List<Product> list = new ArrayList<>();

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM Products WHERE Category=? AND Price>? ORDER BY Quantity DESC")) {

            ps.setString(1, category);
            ps.setDouble(2, price);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(mapRow(rs));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // ===================== HELPER =====================
    private static Product mapRow(ResultSet rs) throws SQLException {
        Product p = new Product();
        p.setProductID(rs.getInt(1));
        p.setProductName(rs.getString(2));
        p.setCategory(rs.getString(3));
        p.setPrice(rs.getDouble(4));
        p.setQuantity(rs.getInt(5));
        return p;
    }
}