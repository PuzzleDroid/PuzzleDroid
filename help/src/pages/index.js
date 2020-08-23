import React from "react";
import Layout from "@theme/Layout";
import { Redirect } from "@docusaurus/router";
import useDocusaurusContext from "@docusaurus/useDocusaurusContext";

function Home() {
  const context = useDocusaurusContext();
  const { siteConfig = {} } = context;
  return <Redirect to="/docs" />;
}

export default Home;
