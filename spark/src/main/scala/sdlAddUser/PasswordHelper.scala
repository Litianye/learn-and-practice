package sdlAddUser

import org.apache.shiro.crypto.SecureRandomNumberGenerator
import org.apache.shiro.crypto.hash.SimpleHash
import org.apache.shiro.util.ByteSource

/**
  * Created by tend on 2017/3/4.
  */
class PasswordHelper {
  val randomNumberGenerator = new SecureRandomNumberGenerator
  val algorithmName: String = "md5"
  val hashIterations: Int = 2

  def encryptPassword(user: User): Unit = {
    user.salt = randomNumberGenerator.nextBytes().toHex
    val newPassword = new SimpleHash(
      algorithmName,
      user.password,
      ByteSource.Util.bytes(user.getCredentialsSalt()),
      hashIterations
    ).toHex
    user.password = newPassword
  }

  /**
    * this method is for kerberos hdfs.
   */
  def encryptPassword(str:String):String={
    val key:Byte=1
    val pb=str.getBytes("utf-8")
    val npb=pb.map(a=>(a^key).toByte)
    new String(npb,"utf-8")
  }
}
