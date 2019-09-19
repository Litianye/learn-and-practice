package sdlAddUser

import scalikejdbc._

/** Created by litianye on 2019-06-20 */
object addUser {

  val passwordHelper = new PasswordHelper
  implicit val session = AutoSession

  def main(args: Array[String]): Unit = {
    val settings = ConnectionPoolSettings(
      initialSize = 5,
      maxSize = 40,
      connectionTimeoutMillis = 3000,
      validationQuery = "select 1 from dual")
    Class.forName("com.mysql.jdbc.Driver")

    ConnectionPool.singleton(s"jdbc:mysql://172.29.133.42:3306/dsp", "root", "", settings)

    addUser(args(0))
  }

  def addUser(unames: String): Unit = {
    for (uname: String <- unames.split(",")) {
      val username = uname+"_TalkingData"
      val groupid = 20
      var password = uname.split("@")(0)

      println("adduser: ", uname, password)

      val locked = 0
      val user = new User(username, uname, groupid, password, false, uname)
      user.setRoleIds(List(1))
      passwordHelper.encryptPassword(user)
      password = user.password
      val salt = user.salt

      val sqlStr = s"insert into `user` (username, uname, realname, groupid, password, salt, locked, email) values ('${username}', '${uname}', '${uname}', ${groupid}, '${password}', '${salt}', ${locked}, '${uname}')"
      SQL(sqlStr).execute().apply()
    }
  }
}
