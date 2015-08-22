package com.maplookup.exception;

public class MaplookupException extends Exception{

	/*
	    * Please do not define constants here. Use ExceptionConstants so that they can
	    * be shared by one and all. Keep this class as light as possible with minimal logic
	    */

	   private static final long serialVersionUID = 1126005857397483602L;

	   public static final int CODE_UNDEFINED = 0;
	    public static final int CODE_UNDEFINED_NESTED = Integer.MAX_VALUE;
	    public static final int INVALID_ARGUMENTS = 5000;
	    public static final int EX_DATA_NOT_FOUND = 6001;
	    public static final String INTERNAL_ERR_MSG = "An internal error has occurred";
	   /*
	    * Code 1 - 4998 - Fatal [Last used code: 10]
	    * Code 4999 - Unknown fatal exception used by DataAccess layer
	    * Code 5000 - 9999 - Application errors [Last used code: 5057]
	    *
	    */
	   private int code = CODE_UNDEFINED;


	   public MaplookupException(String message) {
	      super(message);
	   }

	   public MaplookupException(String message, Throwable cause) {
	      super(message, cause);
	   }

	   public MaplookupException(int code, String message) {
	      super(message);
	      this.code = code;
	   }

	   public MaplookupException(int code, Throwable cause) {
	      super(cause);
	      this.code = code;
	   }

	   public MaplookupException(int code, String message, Throwable cause) {
	      super(message, cause);
	      this.code = code;
	   }

	   public boolean isFatal() {
	      return (this.code != CODE_UNDEFINED && (this.code > 1 && this.code < 5000));
	   }

	   public int getErrorCode() {
	      return this.code;
	   }

}
