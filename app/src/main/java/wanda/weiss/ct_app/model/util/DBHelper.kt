package wanda.weiss.ct_app.model.util

import org.richit.easiestsqllib.Column
import org.richit.easiestsqllib.Datum
import org.richit.easiestsqllib.EasiestDB
import timber.log.Timber

fun init(easiestDB: EasiestDB) {
    easiestDB.addTableColumns("users",
        Column("email", "text", "unique"),
        Column("password", "text")
    ).doneAddingTables()

    easiestDB.addDataInTable(0,
        Datum("email", "jsonjuliane@gmail.com"),
        Datum("password", "test1234")
    )

    find(easiestDB, "jsonjuliane@gmail.com", "test1234")
}

fun find(easiestDB: EasiestDB, email: String, password: String): Boolean {
    val cursor = easiestDB.searchValuesInMultipleColumns(0,
        Datum("email", email),
        Datum("password", password))
    return(cursor != null && cursor.count > 0)
}