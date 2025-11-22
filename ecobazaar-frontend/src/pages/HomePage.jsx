import React, { useState, useEffect } from 'react';
import { motion } from 'framer-motion';
import { Button } from '../components/ui/Button';
import { Card, CardContent } from '../components/ui/Card';
import ProductCard from '../components/ProductCard';
import { productsAPI, categoriesAPI } from '../services/api';
import { 
  Leaf, 
  TrendingDown, 
  Award, 
  Users,
  ArrowRight,
  Filter
} from 'lucide-react';

const HomePage = () => {
  const [products, setProducts] = useState([]);
  const [categories, setCategories] = useState([]);
  const [loading, setLoading] = useState(true);
  const [selectedCategory, setSelectedCategory] = useState('all');
  const [sortBy, setSortBy] = useState('default');

  useEffect(() => {
    loadData();
  }, []);

  const loadData = async () => {
    try {
      setLoading(true);
      const [productsRes, categoriesRes] = await Promise.all([
        productsAPI.getAll(),
        categoriesAPI.getAll()
      ]);
      setProducts(productsRes.data);
      setCategories(categoriesRes.data);
    } catch (error) {
      console.error('Error loading data:', error);
    } finally {
      setLoading(false);
    }
  };

  const handleCategoryFilter = async (categoryId) => {
    setSelectedCategory(categoryId);
    try {
      const response = categoryId === 'all' 
        ? await productsAPI.getAll()
        : await productsAPI.getByCategory(categoryId);
      setProducts(response.data);
    } catch (error) {
      console.error('Error filtering products:', error);
    }
  };

  const handleSort = async (sortType) => {
    setSortBy(sortType);
    try {
      let response;
      switch (sortType) {
        case 'carbon-asc':
          response = await productsAPI.getByCarbonFootprintAsc();
          break;
        case 'carbon-desc':
          response = await productsAPI.getByCarbonFootprintDesc();
          break;
        default:
          response = await productsAPI.getAll();
      }
      setProducts(response.data);
    } catch (error) {
      console.error('Error sorting products:', error);
    }
  };

  const handleAddToCart = (product) => {
    // Add to cart logic
    console.log('Added to cart:', product);
  };

  const handleViewDetails = (product) => {
    // Navigate to product details
    console.log('View details:', product);
  };

  return (
    <div className="min-h-screen bg-gradient-to-br from-eco-50 via-white to-eco-50">
      {/* Hero Section */}
      <section className="relative overflow-hidden">
        <div className="absolute inset-0 bg-gradient-to-r from-eco-600/20 to-eco-800/20"></div>
        <div className="container mx-auto px-4 py-20 relative">
          <div className="grid lg:grid-cols-2 gap-12 items-center">
            <motion.div
              initial={{ opacity: 0, x: -50 }}
              animate={{ opacity: 1, x: 0 }}
              transition={{ duration: 0.6 }}
            >
              <h1 className="text-5xl lg:text-6xl font-bold mb-6">
                Shop with 
                <span className="bg-gradient-to-r from-eco-500 to-eco-700 bg-clip-text text-transparent">
                  {" "}Purpose
                </span>
              </h1>
              <p className="text-xl text-gray-600 mb-8 leading-relaxed">
                Discover eco-friendly products with transparent carbon footprint data. 
                Make informed choices for a sustainable future.
              </p>
              <div className="flex flex-col sm:flex-row gap-4">
                <Button variant="eco" size="lg" className="text-lg px-8">
                  Start Shopping
                  <ArrowRight className="ml-2 w-5 h-5" />
                </Button>
                <Button variant="outline" size="lg" className="text-lg px-8">
                  Learn More
                </Button>
              </div>
            </motion.div>
            
            <motion.div
              initial={{ opacity: 0, x: 50 }}
              animate={{ opacity: 1, x: 0 }}
              transition={{ duration: 0.6, delay: 0.2 }}
              className="relative"
            >
              <img
                src="https://images.unsplash.com/photo-1542601906990-b4d3fb778b09?w=600&h=400&fit=crop"
                alt="Sustainable Shopping"
                className="rounded-2xl shadow-2xl w-full"
              />
              <div className="absolute -bottom-6 -left-6 bg-white p-4 rounded-xl shadow-lg">
                <div className="flex items-center gap-3">
                  <div className="w-12 h-12 bg-eco-100 rounded-full flex items-center justify-center">
                    <Leaf className="w-6 h-6 text-eco-600" />
                  </div>
                  <div>
                    <div className="font-semibold text-gray-800">Carbon Neutral</div>
                    <div className="text-sm text-gray-600">Shipping Available</div>
                  </div>
                </div>
              </div>
            </motion.div>
          </div>
        </div>
      </section>

      {/* Stats Section */}
      <section className="py-16 bg-white">
        <div className="container mx-auto px-4">
          <div className="grid grid-cols-2 lg:grid-cols-4 gap-8">
            {[
              { icon: Leaf, label: 'CO₂ Saved', value: '2.5M kg', color: 'eco' },
              { icon: TrendingDown, label: 'Carbon Reduction', value: '45%', color: 'blue' },
              { icon: Award, label: 'Eco Products', value: '10K+', color: 'purple' },
              { icon: Users, label: 'Happy Customers', value: '50K+', color: 'orange' }
            ].map((stat, index) => (
              <motion.div
                key={index}
                initial={{ opacity: 0, y: 20 }}
                animate={{ opacity: 1, y: 0 }}
                transition={{ duration: 0.5, delay: index * 0.1 }}
              >
                <Card className="text-center p-6 hover:shadow-lg transition-shadow">
                  <CardContent className="p-0">
                    <div className={`w-16 h-16 bg-${stat.color}-100 rounded-full flex items-center justify-center mx-auto mb-4`}>
                      <stat.icon className={`w-8 h-8 text-${stat.color}-600`} />
                    </div>
                    <div className="text-3xl font-bold text-gray-800 mb-2">{stat.value}</div>
                    <div className="text-gray-600">{stat.label}</div>
                  </CardContent>
                </Card>
              </motion.div>
            ))}
          </div>
        </div>
      </section>

      {/* Products Section */}
      <section className="py-16">
        <div className="container mx-auto px-4">
          <div className="text-center mb-12">
            <h2 className="text-4xl font-bold mb-4">Featured Eco Products</h2>
            <p className="text-xl text-gray-600 max-w-2xl mx-auto">
              Discover our curated selection of sustainable products with transparent environmental impact data.
            </p>
          </div>

          {/* Filters */}
          <div className="flex flex-wrap gap-4 mb-8 justify-center">
            <div className="flex items-center gap-2">
              <Filter className="w-4 h-4 text-gray-500" />
              <span className="text-sm font-medium text-gray-700">Filter by:</span>
            </div>
            
            <Button
              variant={selectedCategory === 'all' ? 'eco' : 'outline'}
              size="sm"
              onClick={() => handleCategoryFilter('all')}
            >
              All Products
            </Button>
            
            {categories.map((category) => (
              <Button
                key={category.categoryId}
                variant={selectedCategory === category.categoryId ? 'eco' : 'outline'}
                size="sm"
                onClick={() => handleCategoryFilter(category.categoryId)}
              >
                {category.categoryName}
              </Button>
            ))}
          </div>

          <div className="flex flex-wrap gap-4 mb-8 justify-center">
            <span className="text-sm font-medium text-gray-700">Sort by:</span>
            <Button
              variant={sortBy === 'default' ? 'eco' : 'outline'}
              size="sm"
              onClick={() => handleSort('default')}
            >
              Default
            </Button>
            <Button
              variant={sortBy === 'carbon-asc' ? 'eco' : 'outline'}
              size="sm"
              onClick={() => handleSort('carbon-asc')}
            >
              Lowest Carbon
            </Button>
            <Button
              variant={sortBy === 'carbon-desc' ? 'eco' : 'outline'}
              size="sm"
              onClick={() => handleSort('carbon-desc')}
            >
              Highest Carbon
            </Button>
          </div>

          {/* Products Grid */}
          {loading ? (
            <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 xl:grid-cols-4 gap-6">
              {[...Array(8)].map((_, i) => (
                <div key={i} className="animate-pulse">
                  <div className="bg-gray-200 h-48 rounded-lg mb-4"></div>
                  <div className="bg-gray-200 h-4 rounded mb-2"></div>
                  <div className="bg-gray-200 h-4 rounded w-2/3"></div>
                </div>
              ))}
            </div>
          ) : (
            <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 xl:grid-cols-4 gap-6">
              {products.map((product) => (
                <ProductCard
                  key={product.productId}
                  product={product}
                  onAddToCart={handleAddToCart}
                  onViewDetails={handleViewDetails}
                />
              ))}
            </div>
          )}
        </div>
      </section>
    </div>
  );
};

export default HomePage;