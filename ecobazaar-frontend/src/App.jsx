import React, { useState, useEffect } from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Header from './components/Header';
import HomePage from './pages/HomePage';
import './index.css';

function App() {
  const [user, setUser] = useState(null);
  const [cartCount, setCartCount] = useState(0);

  useEffect(() => {
    // Check for stored user session
    const storedUser = localStorage.getItem('user');
    if (storedUser) {
      setUser(JSON.parse(storedUser));
    }
  }, []);

  const handleLogin = () => {
    // Mock login for demo
    const mockUser = { 
      userId: 1, 
      name: 'John Doe', 
      email: 'john@example.com',
      role: 'CUSTOMER'
    };
    setUser(mockUser);
    localStorage.setItem('user', JSON.stringify(mockUser));
  };

  const handleLogout = () => {
    setUser(null);
    localStorage.removeItem('user');
    localStorage.removeItem('authToken');
  };

  const handleSearch = (query) => {
    console.log('Searching for:', query);
    // Implement search functionality
  };

  return (
    <Router>
      <div className="min-h-screen bg-gray-50">
        <Header
          cartCount={cartCount}
          onSearch={handleSearch}
          user={user}
          onLogin={handleLogin}
          onLogout={handleLogout}
        />
        
        <main>
          <Routes>
            <Route path="/" element={<HomePage />} />
            {/* Add more routes as needed */}
          </Routes>
        </main>
        
        {/* Footer */}
        <footer className="bg-gray-900 text-white py-12 mt-20">
          <div className="container mx-auto px-4">
            <div className="grid grid-cols-1 md:grid-cols-4 gap-8">
              <div>
                <div className="flex items-center space-x-2 mb-4">
                  <div className="w-8 h-8 bg-eco-500 rounded-lg flex items-center justify-center">
                    <span className="text-white font-bold">E</span>
                  </div>
                  <span className="text-xl font-bold">EcoBazaarX</span>
                </div>
                <p className="text-gray-400">
                  Making sustainable shopping accessible and transparent for everyone.
                </p>
              </div>
              
              <div>
                <h3 className="font-semibold mb-4">Products</h3>
                <ul className="space-y-2 text-gray-400">
                  <li>Eco-Friendly Items</li>
                  <li>Carbon Neutral</li>
                  <li>Sustainable Fashion</li>
                  <li>Green Electronics</li>
                </ul>
              </div>
              
              <div>
                <h3 className="font-semibold mb-4">Company</h3>
                <ul className="space-y-2 text-gray-400">
                  <li>About Us</li>
                  <li>Sustainability</li>
                  <li>Careers</li>
                  <li>Contact</li>
                </ul>
              </div>
              
              <div>
                <h3 className="font-semibold mb-4">Support</h3>
                <ul className="space-y-2 text-gray-400">
                  <li>Help Center</li>
                  <li>Shipping Info</li>
                  <li>Returns</li>
                  <li>Privacy Policy</li>
                </ul>
              </div>
            </div>
            
            <div className="border-t border-gray-800 mt-8 pt-8 text-center text-gray-400">
              <p>&copy; 2024 EcoBazaarX. All rights reserved. Built with 💚 for the planet.</p>
            </div>
          </div>
        </footer>
      </div>
    </Router>
  );
}

export default App;