package com.microgrezm.childvaccination.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "children_table")
class ChildData {
    @PrimaryKey(autoGenerate = false)
    val id: Int
    var childName: String
    var childGender: String
    var birthDay: String
    //var arr : ArrayList<datsData>

    var Desc1: String
    var Desc2: String
    var Desc3: String
    var Desc4: String
    var Desc5: String
    var Desc6: String
    var Desc7: String
    var Desc8: String
    var Desc9: String
    var Desc10: String
    var Desc11: String
    var Desc12: String
    var Desc13: String
    var Desc14: String
    var Desc15: String
    var Desc16: String
    var Desc17: String
    var Desc18: String
    var Desc19: String
    var Desc20: String
    var Desc21: String
    var Desc22: String
    var Desc23: String
    var Desc24: String
    var Desc25: String
    var Desc26: String
    var Desc27: String
    var Desc28: String
    var Desc29: String
    var Desc30: String
    var Desc31: String


    constructor(
        id: Int,childName: String, childGender: String, birthDay: String,
        Desc1: String,
        Desc2: String,
        Desc3: String,
        Desc4: String,
        Desc5: String,
        Desc6: String,
        Desc7: String,
        Desc8: String,
        Desc9: String,
        Desc10: String,
        Desc11: String,
        Desc12: String,
        Desc13: String,
        Desc14: String,
        Desc15: String,
        Desc16: String,
        Desc17: String,
        Desc18: String,
        Desc19: String,
        Desc20: String,
        Desc21: String,
        Desc22: String,
        Desc23: String,
        Desc24: String,
        Desc25: String,
        Desc26: String,
        Desc27: String,
        Desc28: String,
        Desc29: String,
        Desc30: String,
        Desc31: String

    ) {
        this.id = id
        //this.arr =arr
        this.childName = childName
        this.childGender = childGender
        this.birthDay = birthDay

        this.Desc1 = Desc1
        this.Desc2 = Desc2
        this.Desc3 = Desc3
        this.Desc4 = Desc4
        this.Desc5 = Desc5
        this.Desc6 = Desc6
        this.Desc7 = Desc7
        this.Desc8 = Desc8
        this.Desc9 = Desc9
        this.Desc10 = Desc10
        this.Desc11 = Desc11
        this.Desc12 = Desc12
        this.Desc13 = Desc13
        this.Desc14 = Desc14
        this.Desc15 = Desc15
        this.Desc16 = Desc16
        this.Desc17 = Desc17
        this.Desc18 = Desc18
        this.Desc19 = Desc19
        this.Desc20 = Desc20
        this.Desc21 = Desc21
        this.Desc22 = Desc22
        this.Desc23 = Desc23
        this.Desc24 = Desc24
        this.Desc25 = Desc25
        this.Desc26 = Desc26
        this.Desc27 = Desc27
        this.Desc28 = Desc28
        this.Desc29 = Desc29
        this.Desc30 = Desc30
        this.Desc31 = Desc31



    }
}