'use client'

import { Inter } from "next/font/google";
import "./globals.css";
import Header from "@/components/Header";
import Footer from "@/components/Footer";
import React, { useEffect } from "react";
import { useGenerationStore } from "@/lib/state/stateManagament";
import Login from "@/components/login/login";
import { useRouter } from "next/router";

const inter = Inter({ subsets: ["latin"] });

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {

  const {user} = useGenerationStore();
  const {login, paper} = user;

  return (
    <html lang="en">
      <body className={inter.className}>
        {paper!= 'anonimo' &&<Header />}
          {children}
        {paper!= 'anonimo' &&<Footer />}
        </body>
    </html>
  );
}
