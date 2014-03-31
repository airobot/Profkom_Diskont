package ru.smolgu.Profkom_Diskont;

import java.util.HashMap;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;

public final class SharableObject implements Parcelable {

	public static final Parcelable.Creator<SharableObject> CREATOR = new Parcelable.Creator<SharableObject>() {

		public SharableObject createFromParcel(Parcel in) {
			return new SharableObject(in);
		}

		@Override
		public SharableObject[] newArray(int size) {
			return new SharableObject[size];
		}

	};

	private static final HashMap<Long, Object> sSharableMap = new HashMap<Long, Object>(
			3);

	private Object mObject;

	public SharableObject(final Object obj) {
		mObject = obj;
	}

	public SharableObject(Parcel in) {
		readFromParcel(in);
	}

	synchronized private static void put(long key, final Object obj) {
		sSharableMap.put(key, obj);
	}

	synchronized private static Object get(long key) {
		return sSharableMap.remove(key);
	}

	public Object getObject() {
		return mObject;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(final Parcel out, int flags) {
		final long val = SystemClock.elapsedRealtime();
		out.writeLong(val);
		put(val, mObject);
	}

	private void readFromParcel(final Parcel in) {
		final long val = in.readLong();
		mObject = get(val);
	}

}
