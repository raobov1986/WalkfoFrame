package com.raoul.walkfoframe.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import com.raoul.walkfoframe.model.WOF_USER;
import com.raoul.walkfoframe.database.DaoSession;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;



// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * DAO for table WOF__USER.
*/
public class WOF_USERDao extends AbstractDao<WOF_USER, Void> {

    public static final String TABLENAME = "WOF__USER";

    /**
     * Properties of entity WOF_USER.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Email = new Property(0, String.class, "Email", false, "EMAIL");
        public final static Property EmailVerifyDate = new Property(1, String.class, "EmailVerifyDate", false, "EMAIL_VERIFY_DATE");
        public final static Property RegistrationDate = new Property(2, String.class, "RegistrationDate", false, "REGISTRATION_DATE");
        public final static Property LastPassword = new Property(3, String.class, "LastPassword", false, "LAST_PASSWORD");
        public final static Property PrimaryRegistartionName = new Property(4, String.class, "PrimaryRegistartionName", false, "PRIMARY_REGISTARTION_NAME");
        public final static Property Password = new Property(5, String.class, "Password", false, "PASSWORD");
        public final static Property UserName = new Property(6, String.class, "UserName", false, "USER_NAME");
        public final static Property PrimaryRegistartion = new Property(7, String.class, "PrimaryRegistartion", false, "PRIMARY_REGISTARTION");
        public final static Property PasswordChangeDate = new Property(8, String.class, "PasswordChangeDate", false, "PASSWORD_CHANGE_DATE");
    };


    public WOF_USERDao(DaoConfig config) {
        super(config);
    }
    
    public WOF_USERDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'WOF__USER' (" + //
                "'EMAIL' TEXT," + // 0: Email
                "'EMAIL_VERIFY_DATE' TEXT," + // 1: EmailVerifyDate
                "'REGISTRATION_DATE' TEXT," + // 2: RegistrationDate
                "'LAST_PASSWORD' TEXT," + // 3: LastPassword
                "'PRIMARY_REGISTARTION_NAME' TEXT," + // 4: PrimaryRegistartionName
                "'PASSWORD' TEXT," + // 5: Password
                "'USER_NAME' TEXT," + // 6: UserName
                "'PRIMARY_REGISTARTION' TEXT," + // 7: PrimaryRegistartion
                "'PASSWORD_CHANGE_DATE' TEXT);"); // 8: PasswordChangeDate
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'WOF__USER'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, WOF_USER entity) {
        stmt.clearBindings();
 
        String Email = entity.getEmail();
        if (Email != null) {
            stmt.bindString(1, Email);
        }
 
        String EmailVerifyDate = entity.getEmailVerifyDate();
        if (EmailVerifyDate != null) {
            stmt.bindString(2, EmailVerifyDate);
        }
 
        String RegistrationDate = entity.getRegistrationDate();
        if (RegistrationDate != null) {
            stmt.bindString(3, RegistrationDate);
        }
 
        String LastPassword = entity.getLastPassword();
        if (LastPassword != null) {
            stmt.bindString(4, LastPassword);
        }
 
        String PrimaryRegistartionName = entity.getPrimaryRegistartionName();
        if (PrimaryRegistartionName != null) {
            stmt.bindString(5, PrimaryRegistartionName);
        }
 
        String Password = entity.getPassword();
        if (Password != null) {
            stmt.bindString(6, Password);
        }
 
        String UserName = entity.getUserName();
        if (UserName != null) {
            stmt.bindString(7, UserName);
        }
 
        String PrimaryRegistartion = entity.getPrimaryRegistartion();
        if (PrimaryRegistartion != null) {
            stmt.bindString(8, PrimaryRegistartion);
        }
 
        String PasswordChangeDate = entity.getPasswordChangeDate();
        if (PasswordChangeDate != null) {
            stmt.bindString(9, PasswordChangeDate);
        }
    }

    /** @inheritdoc */
    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    /** @inheritdoc */
    @Override
    public WOF_USER readEntity(Cursor cursor, int offset) {
        WOF_USER entity = new WOF_USER( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // Email
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // EmailVerifyDate
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // RegistrationDate
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // LastPassword
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // PrimaryRegistartionName
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // Password
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // UserName
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // PrimaryRegistartion
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8) // PasswordChangeDate
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, WOF_USER entity, int offset) {
        entity.setEmail(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setEmailVerifyDate(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setRegistrationDate(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setLastPassword(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setPrimaryRegistartionName(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setPassword(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setUserName(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setPrimaryRegistartion(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setPasswordChangeDate(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
     }
    
    /** @inheritdoc */
    @Override
    protected Void updateKeyAfterInsert(WOF_USER entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    /** @inheritdoc */
    @Override
    public Void getKey(WOF_USER entity) {
        return null;
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
