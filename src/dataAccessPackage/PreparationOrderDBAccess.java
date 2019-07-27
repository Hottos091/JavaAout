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
        String idCook;
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

                idCook = data.getString("matriculecuisinier");
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
}
