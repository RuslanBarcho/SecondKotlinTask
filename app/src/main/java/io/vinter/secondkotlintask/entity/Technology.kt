package io.vinter.secondkotlintask.entity

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Technology() : Parcelable {

    @SerializedName("description")
    @Expose
    var description: String? = null
    @SerializedName("format_version")
    @Expose
    var formatVersion: String? = null
    @SerializedName("options")
    @Expose
    var options: String? = null
    @SerializedName("flags")
    @Expose
    var flags: String? = null
    @SerializedName("graphic")
    @Expose
    var graphic: String? = null
    @SerializedName("graphic_alt")
    @Expose
    var graphicAlt: String? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("req1")
    @Expose
    var req1: String? = null
    @SerializedName("req2")
    @Expose
    var req2: String? = null
    @SerializedName("helptext")
    @Expose
    var helptext: String? = null
    @SerializedName("bonus_message")
    @Expose
    var bonusMessage: String? = null

    constructor(parcel: Parcel) : this() {
        description = parcel.readString()
        formatVersion = parcel.readString()
        options = parcel.readString()
        flags = parcel.readString()
        graphic = parcel.readString()
        graphicAlt = parcel.readString()
        name = parcel.readString()
        req1 = parcel.readString()
        req2 = parcel.readString()
        helptext = parcel.readString()
        bonusMessage = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(description)
        parcel.writeString(formatVersion)
        parcel.writeString(options)
        parcel.writeString(this.flags)
        parcel.writeString(graphic)
        parcel.writeString(graphicAlt)
        parcel.writeString(name)
        parcel.writeString(req1)
        parcel.writeString(req2)
        parcel.writeString(helptext)
        parcel.writeString(bonusMessage)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Technology> {
        override fun createFromParcel(parcel: Parcel): Technology {
            return Technology(parcel)
        }

        override fun newArray(size: Int): Array<Technology?> {
            return arrayOfNulls(size)
        }
    }

}