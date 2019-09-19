package sdlAddUser

/**
  * Created by tend on 2017/5/12.
  */
class User extends Serializable{
  var id: Int = _
  var username: String = _
  var uname: String = _
  var groupid: Int = _
  var roleIds: List[Int] = _
  var roleIdsStr: String = _
  var password: String =_
  var salt: String =_
  var locked: Boolean = _
  var email: String = _
  var realname: String = _

  def this(id: Int) {
    this()
    this.id = id
  }

  def this(username: String, groupid: Int) {
    this()
    this.username = username
    this.groupid = groupid
  }

  def this(username: String, password: String) {
    this()
    this.username = username
    this.password = password
  }

  def this(username: String, groupid: Int, password: String, locked: Boolean) {
    this(username, groupid)
    this.password = password
    this.locked = locked
  }

  def this(id: Int, username: String, groupid: Int, password: String, locked: Boolean) {
    this(username, groupid, password, locked)
    this.id = id
  }

  def this(username: String, groupid: Int, password: String, locked: Boolean, email: String) {
    this(username, groupid, password, locked)
    this.email = email
  }

  def this(username: String, uname: String, groupid: Int, password: String, locked: Boolean, email: String) {
    this(username, groupid, password, locked)
    this.uname = uname
    this.email = email
  }

  def this(username: String, uname: String, groupid: Int, password: String, locked: Boolean, email: String, realname: String) {
    this(username, groupid, password, locked)
    this.realname = realname
    this.uname = uname
    this.email = email
    this.realname = email
  }


  def this(username: String, uname: String, groupid: Int, roleId: String, password: String, locked: Boolean, email: String, realname: String) {
    this(username, groupid, password, locked)
    this.roleIdsStr = roleId
    this.realname = realname
    this.uname = uname
    this.email = email
  }

  def this(username: String, uname: String, groupid: Int, password: String,salt: String, locked: Boolean, email: String) {
    this(username, groupid, password, locked)
    this.uname = uname
    this.email = email
    this.salt = salt
  }

  def this(id: Int, username: String, uname: String, groupid: Int, roleIdsStr: String,
           password: String,salt: String, locked: Boolean, email: String) {
    this(username, groupid, password, locked)
    this.uname = uname
    this.email = email
    this.salt = salt
    this.id = id
    this.roleIdsStr = roleIdsStr
  }

  def this(id: Int, username: String, uname: String, groupid: Int, roleIdsStr: String,
           password: String,salt: String, locked: Boolean, email: String, realname: String) {
    this(username, groupid, password, locked)
    this.uname = uname
    this.email = email
    this.salt = salt
    this.id = id
    this.roleIdsStr = roleIdsStr
    this.realname = realname
  }

  def getCredentialsSalt(): String = {
    username+salt
  }

  def getRoleIdsStr(): String = {
    if (roleIds.isEmpty) ""
    else {
      val s = new StringBuilder
      for (roleId <- roleIds) s.append(roleId+",")
      s.toString()
    }
  }

  def getRoleIds(): List[Int] = {
    setRoleIds()
    if (roleIds == null) {
      roleIds = List()
    }
    roleIds
  }

  def setRoleIds(): Unit = {
    if (roleIdsStr == null) roleIds = List()
    else {
      val temp = roleIdsStr.split(",").toList
      roleIds = temp.map(f => f.toInt)
    }
  }

  def setRoleIds(list: List[Int]): Unit = {
    this.roleIds = list
  }

  override def toString: String = {
    "User { username=" +username+ ", roleId=" +roleIdsStr+ ", locked=" +locked+ ", email=" +email+ "}"
  }
}