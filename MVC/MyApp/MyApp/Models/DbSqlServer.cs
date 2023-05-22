using Microsoft.Data.SqlClient;

namespace MyApp.Models
{
    public class DbSqlServer
    {
        private readonly string _connectionString;

        public DbSqlServer()
        {
            _connectionString = "Data Source=PF3ZWP4V\\SQLEXPRESS;Initial Catalog=md;Integrated Security=True;Encrypt=False;TrustServerCertificate=True";
        }

        public int ConnectAndValidateWithDB(string username, string passwd)
        {
            SqlConnection con = new(_connectionString);


            string qry = "Select 1 from Users where username = '" + username + "' and password = '" + passwd+"'";

            con.Open();
            
            SqlCommand cmd = new(qry, con);

            SqlDataReader rdr = cmd.ExecuteReader();
            if(rdr.Read())
            {
                return 1;
            }
            con.Close();
            return 0; 
            
        }
    }
}
