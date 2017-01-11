package assignment.android.acadgild.person_database;

/**
 * Created by DivyaVipin on 1/10/2017.
 */

public class Constants {

    //COLUMNS
    static final String ROW_ID="id";
    static final String FIRSTNAME="firstname";
    static final String LASTNAME="lastname";
    //DB
    static final String DB_NAME="PERSON_DB";
    static final String TB_NAME="PERSON_TB";
    static final int DB_VERSION=1;

    //CREATE TB
    static final String CREATE_TB="CREATE TABLE PERSON_TB(id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "firstname TEXT NOT NULL ,"+"lastname TEXT NOT NULL);";

    //DROP TB
    static final String DROP_TB="DROP TABLE IF EXISTS "+TB_NAME;


}
