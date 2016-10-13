package com.epam.koval.carrent.db.constants;

/**
 * Constants database.
 * 
 * @author Koval Dmitry
 * @version 1.0
 */
public final class Constants {
    /**
     * Hiden Constructor.
     */
    private Constants() {

    }

    /** Car */
    /** Car fields. */
    public static final String CAR_ID = "id";

    public static final String CAR_MARK = "mark";

    public static final String CAR_MODEL = "model";

    public static final String CAR_CLASS = "class";

    public static final String CAR_COST = "cost";

    public static final String CAR_RENTED = "rented";

    /** Car sql-requests. */
    public static final String CAR_INSERT = "INSERT INTO `car` (`mark`,`model`,`class`,`cost`,`rented`) VALUES (?, ?, ?, ?, ?);";

    public static final String CAR_UPDATE = "UPDATE `car` SET `mark`=?, `model`=?, `class`=?, `cost`=?, `rented`=? WHERE `id`=?;";

    public static final String CAR_DELETE = "DELETE FROM `car` WHERE `id`=?;";

    public static final String CAR_SELECT_ALL = "SELECT `id`, `mark`, `model`, `class`, `cost`, `rented` FROM `car`";

    public static final String CAR_SELECT_ALL_NOT_RENTED = "SELECT * FROM `car` WHERE `rented` = 0";

    public static final String CAR_SELECT_ID = "Select * FROM `car` WHERE id = ?";

    public static final String CAR_SELECT_CLASS = "SELECT * FROM `car` WHERE class = ?";

    public static final String CAR_SELECT_ID_RENTED_PAID = "SELECT DISTINCT id, mark, model, class, cost, rented FROM user_order, car WHERE car.id=? AND user_order.status='paid' AND car.rented=1";

    /** User */
    /** User fields. */
    public static final String USER_ID = "id";

    public static final String USER_EMAIL = "email";

    public static final String USER_PASSWORD = "password";

    public static final String USER_NAME = "name";

    public static final String USER_SURNAME = "surname";

    public static final String USER_BLOCKED = "blocked";

    public static final String USER_ROLE = "role";

    /** User sql-requests. */
    public static final String USER_INSERT = "INSERT INTO `user` (`email`,`password`,`name`,`surname`,`blocked`,`role`) VALUES (?, ?, ?, ?, ?, ?);";

    public static final String USER_UPDATE = "UPDATE `user` SET `email`=?, `password`=?, `name`=?, `surname`=?, `blocked`=?, `role`=? WHERE `id`=?;";

    public static final String USER_DELETE = "DELETE FROM `user` WHERE `id`=?;";

    public static final String USER_SELECT_ALL = "SELECT * FROM `user`;";

    public static final String USER_SELECT_ID = "Select * FROM `user` WHERE `id`=?";

    public static final String USER_SELECT_EMAIL = "SELECT * FROM `user` WHERE `email`=?";

    /** User order */
    /** User order fields. */
    public static final String USER_ORDER_ID = "id";

    public static final String USER_ORDER_CLIENT_ID = "client_id";

    public static final String USER_ORDER_CAR_ID = "car_id";

    public static final String USER_ORDER_PASSPORT_DATA = "passport_data";

    public static final String USER_ORDER_WITH_DRIVER = "with_driver";

    public static final String USER_ORDER_RENT_START = "rent_start";

    public static final String USER_ORDER_RENT_END = "rent_end";

    public static final String USER_ORDER_STATUS = "status";

    /** User order sql-requests. */
    public static final String USER_ORDER_INSERT = "INSERT INTO `user_order` (`client_id`, `car_id`, `passport_data`, `with_driver`, `rent_start`, `rent_end`) VALUES (?, ?, ?, ?, ?, ?);";

    public static final String USER_ORDER_UPDATE = "UPDATE `user_order` SET `client_id`=?, `car_id`=?, `passport_data`=?, `with_driver`=?, `rent_start`=?, `rent_end`=?,`status`=? WHERE `id`=?;";

    public static final String USER_ORDER_DELETE = "DELETE FROM `user_order` WHERE `id` = ?;";

    public static final String USER_ORDER_SELECT_ALL = "SELECT * FROM `user_order`;";

    public static final String USER_ORDER_SELECT_ID = "SELECT * FROM `user_order` WHERE `id` = ?;";

    public static final String USER_ORDER_SELECT_ALL_CLIENT = "SELECT * FROM `user_order` WHERE `client_id`=?;";

}
