// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/Shekhar Kareppananar/Documents/Play/play-samples-play-java-hello-world-tutorial/conf/routes
// @DATE:Sat Jun 27 11:25:54 IST 2020


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
