
using Microsoft.Data.SqlClient;
using System.Runtime.InteropServices;

namespace EmployeeManagement.Models
{
    public class SqlUtils
    {
        private readonly string _connectionString;

        public SqlUtils()
        {
            _connectionString = "Data Source=PF3ZWP4V\\SQLEXPRESS;Initial Catalog=md;Integrated Security=True;Encrypt=False;TrustServerCertificate=True";
        }

        public int CreateLogin(string username, string password)
        {
            SqlConnection con = new SqlConnection(_connectionString);
            con.Open();
            string query = "insert into UserLogins values('"+username+"','"+password+"')";
            SqlCommand cmd = new SqlCommand(query, con);
            int status = cmd.ExecuteNonQuery();
            if (status != 0)
            {
                return 1;
            }
            return 0;
        }
    }
}
