package dataAccessPackage;

import modelPackage.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class PreparationOrderDBAccess {
    public ArrayList<PreparationOrder> getAllPreparationOrders() { // throws AllOrdersException
        ArrayList<PreparationOrder> allPreparationOrders = new ArrayList<>();

        Connection connection = SingletonConnection.getInstance();
        ResultSet data = null;
        //Données query
        PreparationOrder preparationOrder;
        String code;
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


        String sql = "SELECT * from ordrepreparation;";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            data = statement.executeQuery();

            while (data.next()) {
                preparationOrder = new PreparationOrder();

                code = data.getString("code");
                preparationOrder.setCode(code);

                orderRecipeLabel = data.getString("ordrerecettelabel");
                preparationOrder.setLabelRecipe(orderRecipeLabel);

                idCook = data.getInt("matriculecuisinier");
                preparationOrder.setCookIdNumber(idCook);

                pricePortion = data.getDouble("prixportion");
                preparationOrder.setPricePortion(pricePortion);

                productionDate = data.getDate("dateproduction");
                if (!data.wasNull()) {
                    GregorianCalendar calendar = new GregorianCalendar();
                    calendar.setTime(productionDate);
                    preparationOrder.setProductionDate(calendar);
                }

                expiryDate = data.getDate("dateperemption");
                if (!data.wasNull()) {
                    GregorianCalendar calendar = new GregorianCalendar();
                    calendar.setTime(expiryDate);
                    preparationOrder.setExpiryDate(calendar);
                }

                saleDate = data.getDate("datevente");
                if (!data.wasNull()) {
                    GregorianCalendar calendar = new GregorianCalendar();
                    calendar.setTime(saleDate);
                    preparationOrder.setSaleDate(calendar);
                }

                nbPortions = data.getInt("nombreportions");
                preparationOrder.setNumberPortions(nbPortions);

                chiefCommentary = data.getString("commentairechefcuisinier");
                if (!data.wasNull()) {
                    preparationOrder.setChiefCommentary(chiefCommentary);
                }

                cookCommentary = data.getString("commentairecuisinier");
                if (!data.wasNull()) {
                    preparationOrder.setCookCommentary(cookCommentary);
                }
                allPreparationOrders.add(preparationOrder);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return allPreparationOrders;
    }

    public void addPreparationOrder(PreparationOrder preparationOrder){
        Connection connection = SingletonConnection.getInstance();

        java.sql.Date prodSqlDate = new java.sql.Date(preparationOrder.getProductionDate().getTimeInMillis());
        java.sql.Date expirySqlDate = new java.sql.Date(preparationOrder.getExpiryDate().getTimeInMillis());
        java.sql.Date saleSqlDate = new java.sql.Date(preparationOrder.getSaleDate().getTimeInMillis());
        preparationOrder.setUrgent(true);
        String sql = "INSERT INTO ordrepreparation (ordrerecettelabel, matriculecuisinier, prixportion, " +
                "dateproduction, dateperemption, datevente, nombreportions, commentairechefcuisinier, " +
                "commentairecuisinier, esturgent) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

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
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void deletePreparationOrder(Integer preparationOrderId) {
        Connection connection = SingletonConnection.getInstance();

        String sql = "DELETE FROM ordrepreparation WHERE code='" + preparationOrderId + "';";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.executeUpdate();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
}
