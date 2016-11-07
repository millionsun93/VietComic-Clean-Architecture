package com.quanlt.vietcomicclean.presentation.exception;

import android.content.Context;

import com.quanlt.vietcomicclean.R;
import com.quanlt.vietcomicclean.data.exception.NetworkException;


public class ErrorMessageFactory {

    private ErrorMessageFactory() {
    }

    public static String create(Context context, Exception exception) {
        String message = context.getString(R.string.exception_message_generic);
        if (exception instanceof NetworkException) {
            message = context.getString(R.string.exception_message_no_connection);
        }
        return message;
    }
}
