пакет  command_features ;

public  enum  Command {
    CMD_PING ( " ^ # (p | ping) :? " ),
    CMD_ECHO ( " ^ # (ec | echo) :? \\ s (([A-Za-z0-9_ \\ s])?) +; " ),
    CMD_GEN ( " ^ # (g | gen | generation):? \\ s ((p | path | pathToFile) (- | \\ s) (.) +) \\ s ((n | name | nameFile) (- | \\ s) (.) +) +; " ),
    CMD_PROCESS ( " ^ # (pr | process) :? \\ s ((r | rand | randomFile) (- | \\ s) (.) +) \\ s ((s | sort | sortFile) (- | \ \ s) (.) +) +; " );

    закрытый  финал  String regex;

    Command ( последнее  строковое  регулярное выражение ) {
        это . регулярное выражение = регулярное выражение;
    }

    public  String  getRegex () {
        вернуть регулярное выражение;
    }
}
