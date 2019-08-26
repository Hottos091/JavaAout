package dataAccessPackage;

import controllerPackage.ApplicationController;
import modelPackage.*;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class PreparationOrderDBAccess implements PreparationOrderDBAccessDA{

    public ArrayList<PreparationOrder> getAllPreparationOrders() {
        ArrayList<PreparationOrder> allPreparationOrders = new ArrayList<>();

        Connection connection = SingletonConnection.getInstance();
        ResultSet data = null;
        //Données query
        PreparationOrder preparationOrder;
        Integer code;
        String orderRecipeLabel;
        Integer idCook;
        double pricePortion;
        java.sql.Date productionDate;
        java.sql.Date expiryDate;
        java.sql.Date saleDate;
        int nbPortions;
        String chiefCommentary;
        String cookCommentary;
        boolean isUrgent;

        String sql = "SELECT * from preparationorder";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            data = statement.executeQuery();

            while (data.next()) {
                preparationOrder = new PreparationOrder();

                code = data.getInt("code");
                preparationOrder.setCode(code);

                orderRecipeLabel = data.getString("recipe_label");
                preparationOrder.setLabelRecipe(orderRecipeLabel);

                idCook = data.getInt("cook_id");
                preparationOrder.setCookIdNumber(idCook);

                pricePortion = data.getDouble("price_portion");
                preparationOrder.setPricePortion(pricePortion);

                productionDate = data.getDate("production_date");
                if (!data.wasNull()) {
                    GregorianCalendar calendar = new GregorianCalendar();
                    calendar.setTime(productionDate);
                    preparationOrder.setProductionDate(calendar);
                }

                expiryDate = data.getDate("expiry_date");
                if (!data.wasNull()) {
                    GregorianCalendar calendar = new GregorianCalendar();
                    calendar.setTime(expiryDate);
                    preparationOrder.setExpiryDate(calendar);
                }

                saleDate = data.getDate("sale_date");
                if (!data.wasNull()) {
                    GregorianCalendar calendar = new GregorianCalendar();
                    calendar.setTime(saleDate);
                    preparationOrder.setSaleDate(calendar);
                }

                nbPortions = data.getInt("nb_portion");
                preparationOrder.setNumberPortions(nbPortions);

                chiefCommentary = data.getString("chief_comm");
                if (!data.wasNull()) {
                    preparationOrder.setChiefCommentary(chiefCommentary);
                }

                cookCommentary = data.getString("cook_comm");
                if (!data.wasNull()) {
                    preparationOrder.setCookCommentary(cookCommentary);
                }
                isUrgent = data.getBoolean("is_urgent");
                preparationOrder.setIsUrgent(isUrgent);
                allPreparationOrders.add(preparationOrder);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Echec de l'obtention des ordres de préparation.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        return allPreparationOrders;
    }

    public void addPreparationOrder(PreparationOrder preparationOrder) {
        Connection connection = SingletonConnection.getInstance();


        java.sql.Date prodSqlDate = new java.sql.Date(preparationOrder.getProductionDate().getTimeInMillis());
        java.sql.Date expirySqlDate = new java.sql.Date(preparationOrder.getExpiryDate().getTimeInMillis());
        java.sql.Date saleSqlDate = new java.sql.Date(preparationOrder.getSaleDate().getTimeInMillis());
        Boolean isUrgent = preparationOrder.getIsUrgent();

        String sql = "INSERT INTO preparationorder (recipe_label, cook_id, price_portion, " +
                "production_date, expiry_date, sale_date, nb_portion, chief_comm, " +
                "cook_comm, is_urgent) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, preparationOrder.getLabelRecipe());
            statement.setInt(2, preparationOrder.getCookIdNumber());
            statement.setDouble(3, preparationOrder.getPricePortion());
            statement.setDate(4, prodSqlDate);
            statement.setDate(5, expirySqlDate);
            statement.setDate(6, saleSqlDate);
            statement.setInt(7, preparationOrder.getNumberPortions());
            statement.setString(8, preparationOrder.getChiefCommentary());
            statement.setString(9, preparationOrder.getCookCommentary());
            statement.setBoolean(10, preparationOrder.getIsUrgent());

            statement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Echec de l'ajout de l'ordre de préparation dans la base de données.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deletePreparationOrder(Integer preparationOrderId) {
        Connection connection = SingletonConnection.getInstance();

        String sql = "DELETE FROM preparationorder WHERE code=?;";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, preparationOrderId);
            statement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Echec de la suppression de l'ordre de préparation dans la base de données.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void modifyPreparationOrder(PreparationOrder preparationOrder) {
        Connection connection = SingletonConnection.getInstance();

        java.sql.Date prodSqlDate = new java.sql.Date(preparationOrder.getProductionDate().getTimeInMillis());
        java.sql.Date expirySqlDate = new java.sql.Date(preparationOrder.getExpiryDate().getTimeInMillis());
        java.sql.Date saleSqlDate = new java.sql.Date(preparationOrder.getSaleDate().getTimeInMillis());

        String sql = "UPDATE preparationorder " +
                "SET recipe_label = ?" +
                ", cook_id = ?" +
                ", price_portion = ?" +
                ", production_date = ?" +
                ", expiry_date = ?" +
                ", sale_date = ?" +
                ", nb_portion = ?" +
                ", chief_comm = ?" +
                ", cook_comm = ?" +
                ", is_urgent = ?" +
                " where code = ?;";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, preparationOrder.getLabelRecipe());
            statement.setInt(2, preparationOrder.getCookIdNumber());
            statement.setDouble(3, preparationOrder.getPricePortion());
            statement.setDate(4, prodSqlDate);
            statement.setDate(5, expirySqlDate);
            statement.setDate(6, saleSqlDate);
            statement.setInt(7, preparationOrder.getNumberPortions());
            statement.setString(8, preparationOrder.getChiefCommentary());
            statement.setString(9, preparationOrder.getCookCommentary());
            statement.setBoolean(10, preparationOrder.getIsUrgent());
            statement.setInt(11, preparationOrder.getCode());

            statement.executeUpdate();
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Echec de la modification de l'ordre de préparation dans la base de données.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    public ArrayList<ResearchResult> getResearchPreparationOrders(GregorianCalendar date1, GregorianCalendar date2) {
        ArrayList<ResearchResult> researchData = new ArrayList<>();
        Connection connection = SingletonConnection.getInstance();
        ResultSet dataRS = null;
        //Données query
        java.sql.Date productionDate;
        String labelRecipe;
        Integer quantity;
        String labelIngredient;

        java.sql.Date date1sql = new java.sql.Date(date1.getTimeInMillis());
        java.sql.Date date2sql = new java.sql.Date(date2.getTimeInMillis());
        String sql = "SELECT o.production_date, r.recipe_label, i.label_ingredient, c.required_quantity\n" +
                "FROM Composition c, Recipe r, PreparationOrder o, Ingredient i\n" +
                "WHERE c.recipe_label = r.recipe_label\n" +
                "AND o.recipe_label = c.recipe_label\n" +
                "AND i.label_ingredient = c.label_ingredient\n" +
                "AND o.production_date BETWEEN \"" + date1sql + "\" AND \"" + date2sql + "\" \n" +
                "ORDER BY o.production_date, r.recipe_label;";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            dataRS = statement.executeQuery();

            while (dataRS.next()) {
                ResearchResult researchResult = new ResearchResult();

                productionDate = dataRS.getDate("production_date");
                if (!dataRS.wasNull()) {
                    GregorianCalendar calendar = new GregorianCalendar();
                    calendar.setTime(productionDate);
                    researchResult.setProductionDate(calendar);
                }

                labelRecipe = dataRS.getString("recipe_label");
                researchResult.setLabelRecipe(labelRecipe);

                quantity = dataRS.getInt("required_quantity");
                researchResult.setQuantity(quantity);

                labelIngredient = dataRS.getString("label_ingredient");
                researchResult.setLabelIngredient(labelIngredient);

                researchData.add(researchResult);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return researchData;
    }
}