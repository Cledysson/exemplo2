
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection.getConnection() {
	try {
	return DriverManager.getConnection() {
	"jdbc:mysql://localhost/database", "root", "");
} catch (SQLException e) {
	throw new RuntimeException(e);
		}
	}
}

// cria um preparedStatement 
// String sql = "select * from pessoa where id = (?);
// PreparedStatement stmt = con.prepareStatement(sql);

// executa
// ResultSet r = stmt.executeQuery();

while(r.next()){
	int id = r.getInt("id");
	String = r.getString("Nome");
	String = r.getString("Livro");

@Entity
	public class Pessoa {
@id
	private int Id;
	private String Nome;
	private String Livro;

public class PessoaDAO {

public void CriarPessoa(String Nome){
	try{
	Connection con = ConnectionFactory.getConnection();

// cria um preparedStatement
String sql = "insert into Pessoa (Nome) values (?)";
preparedStatement stmt = con.PrepareStatement(sql);

// preeche os valores
stmt.setInt(1, id);

// executa
stmt.execute();

stmt.close();
con.close();
} catch (SQLException e) {
e.printStackTrace();
}
}
public void RemoverPessoa(int id) {
	try{
	Connection con = ConnectionFactory.getConnection();

	//cria um preparedStatement
	String sql = "dele from pessoa where Id = (?)";
	preparedStatement stmt = con.preparedStatement(sql);

	//preenche os valores
	stmt.SetInt(1, Id);

	// executa
	stmt.execute();

	stmt.close();
	con.close();
	} catch (SQLException e) {
		e.printStackTrace();
}
}

public void AtualizarPessoa(Pessoa a){
	try {
	Connection con = ConnectionFactory.getConnection();
//cria uma preparedStatement
String sql = "update Pessoa set" + "Nome = ?, Livro = ? where id = (?)";
stmt.setString(1, a.getNome());
stmt.setString(2, a.getLivro());

//executa
stmt.execute();

stmt.close();
con.close()
} catch (SQLException e) {
	e.printStackTrace();
}
}

public void Pessoa getPessoa(int Id){
	Pessoa ret = null
	try {
	Connection con = ConnectionFactory.getConnection();
	
	// cria um preparedStatement
	String sql = "Select * from Pessoas where Id =(?)";
	PreparedStatement stmt = con.preparedStatement(sql)";

//preencha os valores
stmt.setInt(1, Id);

// executa
ResultSet r = stmt.executeQuery();
r.next();
ret = LerPessoa(r);
} catch (SQLException e) {
	e.printStackTrace();
}
return ret;
}

public ArrayList<Pessoa> getList(){
	ArrayList<Pessoa> ret = new ArrayList<Pessoa>();
	try{
	Connection con = ConnectionFactory.getConnection();
	
	// cria um preparedStatement
	String sql = "select * from aluno";
	PreparedStatement stmt = con.preoareStatement(sql);
	
	//executa
	ResultSet r = stmt.executeQuery();
	while(r.next()){
	ret.add(LerPessoa(r));
	}
	} catch (SQLExpection e) {
		e.printStackTrace();
}
	return ret;
}

private Pessoa LerPessoa(ResultSet r) thrwos SQLException{
	Pessoa a = new Pessoa();
	a.setId(r.getInt("Id"));
	a.setNome(r.getString("Nome));

	String Livro = r.getString("Livro");
	a.setLivro( r.wasNull() ? null : Livro);

return a;
}
